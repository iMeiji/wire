// Code generated by Wire protocol buffer compiler, do not edit.
// Source: google.protobuf.DescriptorProto in google/protobuf/descriptor.proto
package com.google.protobuf

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireField
import com.squareup.wire.internal.checkElementsNotNull
import com.squareup.wire.internal.immutableCopyOf
import com.squareup.wire.internal.redactElements
import com.squareup.wire.internal.sanitize
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.hashCode
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * Describes a message type.
 */
class DescriptorProto(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  @JvmField
  val name: String? = null,
  field: List<FieldDescriptorProto> = emptyList(),
  extension: List<FieldDescriptorProto> = emptyList(),
  nested_type: List<DescriptorProto> = emptyList(),
  enum_type: List<EnumDescriptorProto> = emptyList(),
  extension_range: List<ExtensionRange> = emptyList(),
  oneof_decl: List<OneofDescriptorProto> = emptyList(),
  @field:WireField(
    tag = 7,
    adapter = "com.google.protobuf.MessageOptions#ADAPTER"
  )
  @JvmField
  val options: MessageOptions? = null,
  reserved_range: List<ReservedRange> = emptyList(),
  reserved_name: List<String> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<DescriptorProto, DescriptorProto.Builder>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 2,
    adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val field: List<FieldDescriptorProto> = immutableCopyOf("field", field)

  @field:WireField(
    tag = 6,
    adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val extension: List<FieldDescriptorProto> = immutableCopyOf("extension", extension)

  @field:WireField(
    tag = 3,
    adapter = "com.google.protobuf.DescriptorProto#ADAPTER",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val nested_type: List<DescriptorProto> = immutableCopyOf("nested_type", nested_type)

  @field:WireField(
    tag = 4,
    adapter = "com.google.protobuf.EnumDescriptorProto#ADAPTER",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val enum_type: List<EnumDescriptorProto> = immutableCopyOf("enum_type", enum_type)

  @field:WireField(
    tag = 5,
    adapter = "com.google.protobuf.DescriptorProto${'$'}ExtensionRange#ADAPTER",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val extension_range: List<ExtensionRange> = immutableCopyOf("extension_range", extension_range)

  @field:WireField(
    tag = 8,
    adapter = "com.google.protobuf.OneofDescriptorProto#ADAPTER",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val oneof_decl: List<OneofDescriptorProto> = immutableCopyOf("oneof_decl", oneof_decl)

  @field:WireField(
    tag = 9,
    adapter = "com.google.protobuf.DescriptorProto${'$'}ReservedRange#ADAPTER",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val reserved_range: List<ReservedRange> = immutableCopyOf("reserved_range", reserved_range)

  /**
   * Reserved field names, which may not be used by fields in the same message.
   * A given name may only be reserved once.
   */
  @field:WireField(
    tag = 10,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REPEATED
  )
  @JvmField
  val reserved_name: List<String> = immutableCopyOf("reserved_name", reserved_name)

  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.name = name
    builder.field = field
    builder.extension = extension
    builder.nested_type = nested_type
    builder.enum_type = enum_type
    builder.extension_range = extension_range
    builder.oneof_decl = oneof_decl
    builder.options = options
    builder.reserved_range = reserved_range
    builder.reserved_name = reserved_name
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is DescriptorProto) return false
    if (unknownFields != other.unknownFields) return false
    if (name != other.name) return false
    if (field != other.field) return false
    if (extension != other.extension) return false
    if (nested_type != other.nested_type) return false
    if (enum_type != other.enum_type) return false
    if (extension_range != other.extension_range) return false
    if (oneof_decl != other.oneof_decl) return false
    if (options != other.options) return false
    if (reserved_range != other.reserved_range) return false
    if (reserved_name != other.reserved_name) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + name.hashCode()
      result = result * 37 + field.hashCode()
      result = result * 37 + extension.hashCode()
      result = result * 37 + nested_type.hashCode()
      result = result * 37 + enum_type.hashCode()
      result = result * 37 + extension_range.hashCode()
      result = result * 37 + oneof_decl.hashCode()
      result = result * 37 + options.hashCode()
      result = result * 37 + reserved_range.hashCode()
      result = result * 37 + reserved_name.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (name != null) result += """name=${sanitize(name)}"""
    if (field.isNotEmpty()) result += """field=$field"""
    if (extension.isNotEmpty()) result += """extension=$extension"""
    if (nested_type.isNotEmpty()) result += """nested_type=$nested_type"""
    if (enum_type.isNotEmpty()) result += """enum_type=$enum_type"""
    if (extension_range.isNotEmpty()) result += """extension_range=$extension_range"""
    if (oneof_decl.isNotEmpty()) result += """oneof_decl=$oneof_decl"""
    if (options != null) result += """options=$options"""
    if (reserved_range.isNotEmpty()) result += """reserved_range=$reserved_range"""
    if (reserved_name.isNotEmpty()) result += """reserved_name=${sanitize(reserved_name)}"""
    return result.joinToString(prefix = "DescriptorProto{", separator = ", ", postfix = "}")
  }

  fun copy(
    name: String? = this.name,
    field: List<FieldDescriptorProto> = this.field,
    extension: List<FieldDescriptorProto> = this.extension,
    nested_type: List<DescriptorProto> = this.nested_type,
    enum_type: List<EnumDescriptorProto> = this.enum_type,
    extension_range: List<ExtensionRange> = this.extension_range,
    oneof_decl: List<OneofDescriptorProto> = this.oneof_decl,
    options: MessageOptions? = this.options,
    reserved_range: List<ReservedRange> = this.reserved_range,
    reserved_name: List<String> = this.reserved_name,
    unknownFields: ByteString = this.unknownFields
  ): DescriptorProto = DescriptorProto(name, field, extension, nested_type, enum_type,
      extension_range, oneof_decl, options, reserved_range, reserved_name, unknownFields)

  class Builder : Message.Builder<DescriptorProto, Builder>() {
    @JvmField
    var name: String? = null

    @JvmField
    var field: List<FieldDescriptorProto> = emptyList()

    @JvmField
    var extension: List<FieldDescriptorProto> = emptyList()

    @JvmField
    var nested_type: List<DescriptorProto> = emptyList()

    @JvmField
    var enum_type: List<EnumDescriptorProto> = emptyList()

    @JvmField
    var extension_range: List<ExtensionRange> = emptyList()

    @JvmField
    var oneof_decl: List<OneofDescriptorProto> = emptyList()

    @JvmField
    var options: MessageOptions? = null

    @JvmField
    var reserved_range: List<ReservedRange> = emptyList()

    @JvmField
    var reserved_name: List<String> = emptyList()

    fun name(name: String?): Builder {
      this.name = name
      return this
    }

    fun field(field: List<FieldDescriptorProto>): Builder {
      checkElementsNotNull(field)
      this.field = field
      return this
    }

    fun extension(extension: List<FieldDescriptorProto>): Builder {
      checkElementsNotNull(extension)
      this.extension = extension
      return this
    }

    fun nested_type(nested_type: List<DescriptorProto>): Builder {
      checkElementsNotNull(nested_type)
      this.nested_type = nested_type
      return this
    }

    fun enum_type(enum_type: List<EnumDescriptorProto>): Builder {
      checkElementsNotNull(enum_type)
      this.enum_type = enum_type
      return this
    }

    fun extension_range(extension_range: List<ExtensionRange>): Builder {
      checkElementsNotNull(extension_range)
      this.extension_range = extension_range
      return this
    }

    fun oneof_decl(oneof_decl: List<OneofDescriptorProto>): Builder {
      checkElementsNotNull(oneof_decl)
      this.oneof_decl = oneof_decl
      return this
    }

    fun options(options: MessageOptions?): Builder {
      this.options = options
      return this
    }

    fun reserved_range(reserved_range: List<ReservedRange>): Builder {
      checkElementsNotNull(reserved_range)
      this.reserved_range = reserved_range
      return this
    }

    /**
     * Reserved field names, which may not be used by fields in the same message.
     * A given name may only be reserved once.
     */
    fun reserved_name(reserved_name: List<String>): Builder {
      checkElementsNotNull(reserved_name)
      this.reserved_name = reserved_name
      return this
    }

    override fun build(): DescriptorProto = DescriptorProto(
      name = name,
      field = field,
      extension = extension,
      nested_type = nested_type,
      enum_type = enum_type,
      extension_range = extension_range,
      oneof_decl = oneof_decl,
      options = options,
      reserved_range = reserved_range,
      reserved_name = reserved_name,
      unknownFields = buildUnknownFields()
    )
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<DescriptorProto> = object : ProtoAdapter<DescriptorProto>(
      FieldEncoding.LENGTH_DELIMITED, 
      DescriptorProto::class, 
      "type.googleapis.com/google.protobuf.DescriptorProto", 
      PROTO_2, 
      null
    ) {
      override fun encodedSize(value: DescriptorProto): Int {
        var size = value.unknownFields.size
        size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.name)
        size += FieldDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, value.field)
        size += FieldDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(6, value.extension)
        size += DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(3, value.nested_type)
        size += EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, value.enum_type)
        size += ExtensionRange.ADAPTER.asRepeated().encodedSizeWithTag(5, value.extension_range)
        size += OneofDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(8, value.oneof_decl)
        size += MessageOptions.ADAPTER.encodedSizeWithTag(7, value.options)
        size += ReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(9, value.reserved_range)
        size += ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(10, value.reserved_name)
        return size
      }

      override fun encode(writer: ProtoWriter, value: DescriptorProto) {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        FieldDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.field)
        FieldDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.extension)
        DescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.nested_type)
        EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.enum_type)
        ExtensionRange.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.extension_range)
        OneofDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.oneof_decl)
        MessageOptions.ADAPTER.encodeWithTag(writer, 7, value.options)
        ReservedRange.ADAPTER.asRepeated().encodeWithTag(writer, 9, value.reserved_range)
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 10, value.reserved_name)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): DescriptorProto {
        var name: String? = null
        val field = mutableListOf<FieldDescriptorProto>()
        val extension = mutableListOf<FieldDescriptorProto>()
        val nested_type = mutableListOf<DescriptorProto>()
        val enum_type = mutableListOf<EnumDescriptorProto>()
        val extension_range = mutableListOf<ExtensionRange>()
        val oneof_decl = mutableListOf<OneofDescriptorProto>()
        var options: MessageOptions? = null
        val reserved_range = mutableListOf<ReservedRange>()
        val reserved_name = mutableListOf<String>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> field.add(FieldDescriptorProto.ADAPTER.decode(reader))
            6 -> extension.add(FieldDescriptorProto.ADAPTER.decode(reader))
            3 -> nested_type.add(DescriptorProto.ADAPTER.decode(reader))
            4 -> enum_type.add(EnumDescriptorProto.ADAPTER.decode(reader))
            5 -> extension_range.add(ExtensionRange.ADAPTER.decode(reader))
            8 -> oneof_decl.add(OneofDescriptorProto.ADAPTER.decode(reader))
            7 -> options = MessageOptions.ADAPTER.decode(reader)
            9 -> reserved_range.add(ReservedRange.ADAPTER.decode(reader))
            10 -> reserved_name.add(ProtoAdapter.STRING.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return DescriptorProto(
          name = name,
          field = field,
          extension = extension,
          nested_type = nested_type,
          enum_type = enum_type,
          extension_range = extension_range,
          oneof_decl = oneof_decl,
          options = options,
          reserved_range = reserved_range,
          reserved_name = reserved_name,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: DescriptorProto): DescriptorProto = value.copy(
        field = value.field.redactElements(FieldDescriptorProto.ADAPTER),
        extension = value.extension.redactElements(FieldDescriptorProto.ADAPTER),
        nested_type = value.nested_type.redactElements(DescriptorProto.ADAPTER),
        enum_type = value.enum_type.redactElements(EnumDescriptorProto.ADAPTER),
        extension_range = value.extension_range.redactElements(ExtensionRange.ADAPTER),
        oneof_decl = value.oneof_decl.redactElements(OneofDescriptorProto.ADAPTER),
        options = value.options?.let(MessageOptions.ADAPTER::redact),
        reserved_range = value.reserved_range.redactElements(ReservedRange.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }
  }

  class ExtensionRange(
    /**
     * Inclusive.
     */
    @field:WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    @JvmField
    val start: Int? = null,
    /**
     * Exclusive.
     */
    @field:WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    @JvmField
    val end: Int? = null,
    @field:WireField(
      tag = 3,
      adapter = "com.google.protobuf.ExtensionRangeOptions#ADAPTER"
    )
    @JvmField
    val options: ExtensionRangeOptions? = null,
    unknownFields: ByteString = ByteString.EMPTY
  ) : Message<ExtensionRange, ExtensionRange.Builder>(ADAPTER, unknownFields) {
    override fun newBuilder(): Builder {
      val builder = Builder()
      builder.start = start
      builder.end = end
      builder.options = options
      builder.addUnknownFields(unknownFields)
      return builder
    }

    override fun equals(other: Any?): Boolean {
      if (other === this) return true
      if (other !is ExtensionRange) return false
      if (unknownFields != other.unknownFields) return false
      if (start != other.start) return false
      if (end != other.end) return false
      if (options != other.options) return false
      return true
    }

    override fun hashCode(): Int {
      var result = super.hashCode
      if (result == 0) {
        result = unknownFields.hashCode()
        result = result * 37 + start.hashCode()
        result = result * 37 + end.hashCode()
        result = result * 37 + options.hashCode()
        super.hashCode = result
      }
      return result
    }

    override fun toString(): String {
      val result = mutableListOf<String>()
      if (start != null) result += """start=$start"""
      if (end != null) result += """end=$end"""
      if (options != null) result += """options=$options"""
      return result.joinToString(prefix = "ExtensionRange{", separator = ", ", postfix = "}")
    }

    fun copy(
      start: Int? = this.start,
      end: Int? = this.end,
      options: ExtensionRangeOptions? = this.options,
      unknownFields: ByteString = this.unknownFields
    ): ExtensionRange = ExtensionRange(start, end, options, unknownFields)

    class Builder : Message.Builder<ExtensionRange, Builder>() {
      @JvmField
      var start: Int? = null

      @JvmField
      var end: Int? = null

      @JvmField
      var options: ExtensionRangeOptions? = null

      /**
       * Inclusive.
       */
      fun start(start: Int?): Builder {
        this.start = start
        return this
      }

      /**
       * Exclusive.
       */
      fun end(end: Int?): Builder {
        this.end = end
        return this
      }

      fun options(options: ExtensionRangeOptions?): Builder {
        this.options = options
        return this
      }

      override fun build(): ExtensionRange = ExtensionRange(
        start = start,
        end = end,
        options = options,
        unknownFields = buildUnknownFields()
      )
    }

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<ExtensionRange> = object : ProtoAdapter<ExtensionRange>(
        FieldEncoding.LENGTH_DELIMITED, 
        ExtensionRange::class, 
        "type.googleapis.com/google.protobuf.DescriptorProto.ExtensionRange", 
        PROTO_2, 
        null
      ) {
        override fun encodedSize(value: ExtensionRange): Int {
          var size = value.unknownFields.size
          size += ProtoAdapter.INT32.encodedSizeWithTag(1, value.start)
          size += ProtoAdapter.INT32.encodedSizeWithTag(2, value.end)
          size += ExtensionRangeOptions.ADAPTER.encodedSizeWithTag(3, value.options)
          return size
        }

        override fun encode(writer: ProtoWriter, value: ExtensionRange) {
          ProtoAdapter.INT32.encodeWithTag(writer, 1, value.start)
          ProtoAdapter.INT32.encodeWithTag(writer, 2, value.end)
          ExtensionRangeOptions.ADAPTER.encodeWithTag(writer, 3, value.options)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): ExtensionRange {
          var start: Int? = null
          var end: Int? = null
          var options: ExtensionRangeOptions? = null
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> start = ProtoAdapter.INT32.decode(reader)
              2 -> end = ProtoAdapter.INT32.decode(reader)
              3 -> options = ExtensionRangeOptions.ADAPTER.decode(reader)
              else -> reader.readUnknownField(tag)
            }
          }
          return ExtensionRange(
            start = start,
            end = end,
            options = options,
            unknownFields = unknownFields
          )
        }

        override fun redact(value: ExtensionRange): ExtensionRange = value.copy(
          options = value.options?.let(ExtensionRangeOptions.ADAPTER::redact),
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }

  /**
   * Range of reserved tag numbers. Reserved tag numbers may not be used by
   * fields or extension ranges in the same message. Reserved ranges may
   * not overlap.
   */
  class ReservedRange(
    /**
     * Inclusive.
     */
    @field:WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    @JvmField
    val start: Int? = null,
    /**
     * Exclusive.
     */
    @field:WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    @JvmField
    val end: Int? = null,
    unknownFields: ByteString = ByteString.EMPTY
  ) : Message<ReservedRange, ReservedRange.Builder>(ADAPTER, unknownFields) {
    override fun newBuilder(): Builder {
      val builder = Builder()
      builder.start = start
      builder.end = end
      builder.addUnknownFields(unknownFields)
      return builder
    }

    override fun equals(other: Any?): Boolean {
      if (other === this) return true
      if (other !is ReservedRange) return false
      if (unknownFields != other.unknownFields) return false
      if (start != other.start) return false
      if (end != other.end) return false
      return true
    }

    override fun hashCode(): Int {
      var result = super.hashCode
      if (result == 0) {
        result = unknownFields.hashCode()
        result = result * 37 + start.hashCode()
        result = result * 37 + end.hashCode()
        super.hashCode = result
      }
      return result
    }

    override fun toString(): String {
      val result = mutableListOf<String>()
      if (start != null) result += """start=$start"""
      if (end != null) result += """end=$end"""
      return result.joinToString(prefix = "ReservedRange{", separator = ", ", postfix = "}")
    }

    fun copy(
      start: Int? = this.start,
      end: Int? = this.end,
      unknownFields: ByteString = this.unknownFields
    ): ReservedRange = ReservedRange(start, end, unknownFields)

    class Builder : Message.Builder<ReservedRange, Builder>() {
      @JvmField
      var start: Int? = null

      @JvmField
      var end: Int? = null

      /**
       * Inclusive.
       */
      fun start(start: Int?): Builder {
        this.start = start
        return this
      }

      /**
       * Exclusive.
       */
      fun end(end: Int?): Builder {
        this.end = end
        return this
      }

      override fun build(): ReservedRange = ReservedRange(
        start = start,
        end = end,
        unknownFields = buildUnknownFields()
      )
    }

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<ReservedRange> = object : ProtoAdapter<ReservedRange>(
        FieldEncoding.LENGTH_DELIMITED, 
        ReservedRange::class, 
        "type.googleapis.com/google.protobuf.DescriptorProto.ReservedRange", 
        PROTO_2, 
        null
      ) {
        override fun encodedSize(value: ReservedRange): Int {
          var size = value.unknownFields.size
          size += ProtoAdapter.INT32.encodedSizeWithTag(1, value.start)
          size += ProtoAdapter.INT32.encodedSizeWithTag(2, value.end)
          return size
        }

        override fun encode(writer: ProtoWriter, value: ReservedRange) {
          ProtoAdapter.INT32.encodeWithTag(writer, 1, value.start)
          ProtoAdapter.INT32.encodeWithTag(writer, 2, value.end)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): ReservedRange {
          var start: Int? = null
          var end: Int? = null
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> start = ProtoAdapter.INT32.decode(reader)
              2 -> end = ProtoAdapter.INT32.decode(reader)
              else -> reader.readUnknownField(tag)
            }
          }
          return ReservedRange(
            start = start,
            end = end,
            unknownFields = unknownFields
          )
        }

        override fun redact(value: ReservedRange): ReservedRange = value.copy(
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }
}
