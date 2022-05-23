package com.squareup.wire.schema

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.wire.WireCompiler
import com.squareup.wire.kotlin.BindingGenerator
import com.squareup.wire.kotlin.KotlinGenerator
import com.squareup.wire.kotlin.RpcCallStyle
import com.squareup.wire.kotlin.RpcRole
import java.io.IOException
import okio.Path

data class BindingTarget(
  override val includes: List<String> = listOf("*"),
  override val excludes: List<String> = listOf(),

  override val exclusive: Boolean = true,

  override val outDirectory: String,

  /** True for emitted types to implement `android.os.Parcelable`. */
  val android: Boolean = false,

  /** True for emitted types to implement APIs for easier migration from the Java target. */
  val javaInterop: Boolean = false,

  /** True to emit types for options declared on messages, fields, etc. */
  val emitDeclaredOptions: Boolean = true,

  /** True to emit annotations for options applied on messages, fields, etc. */
  val emitAppliedOptions: Boolean = true,

  /** Blocking or suspending. */
  val rpcCallStyle: RpcCallStyle = RpcCallStyle.SUSPENDING,

  /** Client or server. */
  val rpcRole: RpcRole = RpcRole.CLIENT,

  /** True for emitted services to implement one interface per RPC. */
  val singleMethodServices: Boolean = false,

  /**
   * If a oneof has more than or [boxOneOfsMinSize] fields, it will be generated using boxed oneofs
   * as defined in [OneOf][com.squareup.wire.OneOf].
   */
  val boxOneOfsMinSize: Int = 5_000,

  /** True to also generate gRPC server-compatible classes. Experimental feature. */
  val grpcServerCompatible: Boolean = false,

  /**
   * If present, generated services classes will use this as a suffix instead of inferring one
   * from the [rpcRole].
   */
  val nameSuffix: String? = null,
) : Target() {
  override fun newHandler(): SchemaHandler {
    return object : AbstractSchemaHandler() {
      private lateinit var bindingGenerator: BindingGenerator

      override fun handle(schema: Schema, context: SchemaHandler.Context) {
        val profileName = if (android) "android" else "java"
        val profile = context.profileLoader!!.loadProfile(profileName, schema)
        bindingGenerator = BindingGenerator(
          schema = schema,
          profile = profile,
          emitAndroid = android,
          javaInterop = javaInterop,
          emitDeclaredOptions = emitDeclaredOptions,
          emitAppliedOptions = emitAppliedOptions,
          rpcCallStyle = rpcCallStyle,
          rpcRole = rpcRole,
          boxOneOfsMinSize = boxOneOfsMinSize,
          grpcServerCompatible = grpcServerCompatible,
          nameSuffix = nameSuffix,
        )
        context.fileSystem.createDirectories(context.outDirectory)
        super.handle(schema, context)
      }

      override fun handle(type: Type, context: SchemaHandler.Context): Path? {
        if (KotlinGenerator.builtInType(type.type)) return null

        val typeSpec = bindingGenerator.generateType(type)
        val className = bindingGenerator.generatedTypeName(type)
        return write(className, typeSpec, type.type, type.location, context)
      }

      override fun handle(service: Service, context: SchemaHandler.Context): List<Path> {
        if (rpcRole === RpcRole.NONE) return emptyList()

        val generatedPaths = mutableListOf<Path>()

        if (singleMethodServices) {
          service.rpcs.forEach { rpc ->
            val map = bindingGenerator.generateServiceTypeSpecs(service, rpc)
            for ((className, typeSpec) in map) {
              generatedPaths.add(
                write(className, typeSpec, service.type, service.location, context)
              )
            }
          }
        } else {
          val map = bindingGenerator.generateServiceTypeSpecs(service, null)
          for ((className, typeSpec) in map) {
            generatedPaths.add(write(className, typeSpec, service.type, service.location, context))
          }
        }

        return generatedPaths
      }

      override fun handle(extend: Extend, field: Field, context: SchemaHandler.Context): Path? {
        val typeSpec = bindingGenerator.generateOptionType(extend, field) ?: return null
        val name = bindingGenerator.generatedTypeName(field)
        return write(name, typeSpec, field.qualifiedName, field.location, context)
      }

      private fun write(
        name: ClassName,
        typeSpec: TypeSpec,
        source: Any,
        location: Location,
        context: SchemaHandler.Context,
      ): Path {
        val modulePath = context.outDirectory
        val kotlinFile = FileSpec.builder(name.packageName, name.simpleName)
          .addComment(WireCompiler.CODE_GENERATED_BY_WIRE)
          .addComment("\nSource: %L in %L", source, location.withPathOnly())
          .addType(typeSpec)
          .build()
        val filePath = modulePath /
          kotlinFile.packageName.replace(".", "/") /
          "${kotlinFile.name}.kt"

        context.logger.artifactHandled(
          modulePath, "${kotlinFile.packageName}.${(kotlinFile.members.first() as TypeSpec).name}",
          "Kotlin"
        )
        try {
          context.fileSystem.createDirectories(filePath.parent!!)
          context.fileSystem.write(filePath) {
            writeUtf8(kotlinFile.toString())
          }
        } catch (e: IOException) {
          throw IOException("Error emitting ${kotlinFile.packageName}.$source to $outDirectory", e)
        }
        return filePath
      }
    }
  }

  override fun copyTarget(
    includes: List<String>,
    excludes: List<String>,
    exclusive: Boolean,
    outDirectory: String
  ): Target {
    return copy(
      includes = includes,
      excludes = excludes,
      exclusive = exclusive,
      outDirectory = outDirectory,
    )
  }
}
