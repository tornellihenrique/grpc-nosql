// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nosql_database.proto

package br.ufu.sd.core.grpc.model;

import br.ufu.sd.core.grpc.NoSqlServiceProto;
import br.ufu.sd.core.grpc.abstracts.TStampOrBuilder;

/**
 * <pre>
 * declarando o parametro do tipo timestamp : timestamp
 * </pre>
 *
 * Protobuf type {@code grpc.TStamp}
 */
public final class TStamp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.TStamp)
    TStampOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TStamp.newBuilder() to construct.
  private TStamp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TStamp() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TStamp();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TStamp(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            value_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_TStamp_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_TStamp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.ufu.sd.core.grpc.model.TStamp.class, br.ufu.sd.core.grpc.model.TStamp.Builder.class);
  }

  public static final int VALUE_FIELD_NUMBER = 1;
  private long value_;
  /**
   * <code>int64 value = 1;</code>
   * @return The value.
   */
  @java.lang.Override
  public long getValue() {
    return value_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (value_ != 0L) {
      output.writeInt64(1, value_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (value_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, value_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof br.ufu.sd.core.grpc.model.TStamp)) {
      return super.equals(obj);
    }
    br.ufu.sd.core.grpc.model.TStamp other = (br.ufu.sd.core.grpc.model.TStamp) obj;

    if (getValue()
        != other.getValue()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getValue());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.ufu.sd.core.grpc.model.TStamp parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(br.ufu.sd.core.grpc.model.TStamp prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * declarando o parametro do tipo timestamp : timestamp
   * </pre>
   *
   * Protobuf type {@code grpc.TStamp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.TStamp)
      br.ufu.sd.core.grpc.abstracts.TStampOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_TStamp_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_TStamp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.ufu.sd.core.grpc.model.TStamp.class, br.ufu.sd.core.grpc.model.TStamp.Builder.class);
    }

    // Construct using br.ufu.sd.core.grpc.TStamp.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      value_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_TStamp_descriptor;
    }

    @java.lang.Override
    public br.ufu.sd.core.grpc.model.TStamp getDefaultInstanceForType() {
      return br.ufu.sd.core.grpc.model.TStamp.getDefaultInstance();
    }

    @java.lang.Override
    public br.ufu.sd.core.grpc.model.TStamp build() {
      br.ufu.sd.core.grpc.model.TStamp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public br.ufu.sd.core.grpc.model.TStamp buildPartial() {
      br.ufu.sd.core.grpc.model.TStamp result = new br.ufu.sd.core.grpc.model.TStamp(this);
      result.value_ = value_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof br.ufu.sd.core.grpc.model.TStamp) {
        return mergeFrom((br.ufu.sd.core.grpc.model.TStamp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.ufu.sd.core.grpc.model.TStamp other) {
      if (other == br.ufu.sd.core.grpc.model.TStamp.getDefaultInstance()) return this;
      if (other.getValue() != 0L) {
        setValue(other.getValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      br.ufu.sd.core.grpc.model.TStamp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.ufu.sd.core.grpc.model.TStamp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long value_ ;
    /**
     * <code>int64 value = 1;</code>
     * @return The value.
     */
    @java.lang.Override
    public long getValue() {
      return value_;
    }
    /**
     * <code>int64 value = 1;</code>
     * @param value The value to set.
     * @return This builder for chaining.
     */
    public Builder setValue(long value) {
      
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 value = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearValue() {
      
      value_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.TStamp)
  }

  // @@protoc_insertion_point(class_scope:grpc.TStamp)
  private static final br.ufu.sd.core.grpc.model.TStamp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.ufu.sd.core.grpc.model.TStamp();
  }

  public static br.ufu.sd.core.grpc.model.TStamp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TStamp>
      PARSER = new com.google.protobuf.AbstractParser<TStamp>() {
    @java.lang.Override
    public TStamp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TStamp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TStamp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TStamp> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public br.ufu.sd.core.grpc.model.TStamp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

