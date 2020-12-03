// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nosql_database.proto

package br.ufu.sd.api.contract.request;

import br.ufu.sd.core.grpc.NoSqlServiceProto;
import br.ufu.sd.core.grpc.abstracts.DelVerRequestOrBuilder;
import br.ufu.sd.domain.model.BigInt;

/**
 * Protobuf type {@code grpc.DelVerRequest}
 */
public final class DelVerRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.DelVerRequest)
    DelVerRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DelVerRequest.newBuilder() to construct.
  private DelVerRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DelVerRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DelVerRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DelVerRequest(
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
          case 10: {
            br.ufu.sd.domain.model.BigInt.Builder subBuilder = null;
            if (chave_ != null) {
              subBuilder = chave_.toBuilder();
            }
            chave_ = input.readMessage(br.ufu.sd.domain.model.BigInt.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(chave_);
              chave_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            versao_ = input.readInt64();
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
    return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_DelVerRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_DelVerRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.ufu.sd.api.contract.request.DelVerRequest.class, br.ufu.sd.api.contract.request.DelVerRequest.Builder.class);
  }

  public static final int CHAVE_FIELD_NUMBER = 1;
  private br.ufu.sd.domain.model.BigInt chave_;
  /**
   * <code>.grpc.BigInt chave = 1;</code>
   * @return Whether the chave field is set.
   */
  @java.lang.Override
  public boolean hasChave() {
    return chave_ != null;
  }
  /**
   * <code>.grpc.BigInt chave = 1;</code>
   * @return The chave.
   */
  @java.lang.Override
  public br.ufu.sd.domain.model.BigInt getChave() {
    return chave_ == null ? br.ufu.sd.domain.model.BigInt.getDefaultInstance() : chave_;
  }
  /**
   * <code>.grpc.BigInt chave = 1;</code>
   */
  @java.lang.Override
  public br.ufu.sd.core.grpc.abstracts.BigIntOrBuilder getChaveOrBuilder() {
    return getChave();
  }

  public static final int VERSAO_FIELD_NUMBER = 2;
  private long versao_;
  /**
   * <code>int64 versao = 2;</code>
   * @return The versao.
   */
  @java.lang.Override
  public long getVersao() {
    return versao_;
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
    if (chave_ != null) {
      output.writeMessage(1, getChave());
    }
    if (versao_ != 0L) {
      output.writeInt64(2, versao_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (chave_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getChave());
    }
    if (versao_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, versao_);
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
    if (!(obj instanceof br.ufu.sd.api.contract.request.DelVerRequest)) {
      return super.equals(obj);
    }
    br.ufu.sd.api.contract.request.DelVerRequest other = (br.ufu.sd.api.contract.request.DelVerRequest) obj;

    if (hasChave() != other.hasChave()) return false;
    if (hasChave()) {
      if (!getChave()
          .equals(other.getChave())) return false;
    }
    if (getVersao()
        != other.getVersao()) return false;
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
    if (hasChave()) {
      hash = (37 * hash) + CHAVE_FIELD_NUMBER;
      hash = (53 * hash) + getChave().hashCode();
    }
    hash = (37 * hash) + VERSAO_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getVersao());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.ufu.sd.api.contract.request.DelVerRequest parseFrom(
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
  public static Builder newBuilder(br.ufu.sd.api.contract.request.DelVerRequest prototype) {
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
   * Protobuf type {@code grpc.DelVerRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.DelVerRequest)
      br.ufu.sd.core.grpc.abstracts.DelVerRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_DelVerRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_DelVerRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.ufu.sd.api.contract.request.DelVerRequest.class, br.ufu.sd.api.contract.request.DelVerRequest.Builder.class);
    }

    // Construct using br.ufu.sd.core.grpc.DelVerRequest.newBuilder()
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
      if (chaveBuilder_ == null) {
        chave_ = null;
      } else {
        chave_ = null;
        chaveBuilder_ = null;
      }
      versao_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_DelVerRequest_descriptor;
    }

    @java.lang.Override
    public br.ufu.sd.api.contract.request.DelVerRequest getDefaultInstanceForType() {
      return br.ufu.sd.api.contract.request.DelVerRequest.getDefaultInstance();
    }

    @java.lang.Override
    public br.ufu.sd.api.contract.request.DelVerRequest build() {
      br.ufu.sd.api.contract.request.DelVerRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public br.ufu.sd.api.contract.request.DelVerRequest buildPartial() {
      br.ufu.sd.api.contract.request.DelVerRequest result = new br.ufu.sd.api.contract.request.DelVerRequest(this);
      if (chaveBuilder_ == null) {
        result.chave_ = chave_;
      } else {
        result.chave_ = chaveBuilder_.build();
      }
      result.versao_ = versao_;
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
      if (other instanceof br.ufu.sd.api.contract.request.DelVerRequest) {
        return mergeFrom((br.ufu.sd.api.contract.request.DelVerRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.ufu.sd.api.contract.request.DelVerRequest other) {
      if (other == br.ufu.sd.api.contract.request.DelVerRequest.getDefaultInstance()) return this;
      if (other.hasChave()) {
        mergeChave(other.getChave());
      }
      if (other.getVersao() != 0L) {
        setVersao(other.getVersao());
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
      br.ufu.sd.api.contract.request.DelVerRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.ufu.sd.api.contract.request.DelVerRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private br.ufu.sd.domain.model.BigInt chave_;
    private com.google.protobuf.SingleFieldBuilderV3<
        br.ufu.sd.domain.model.BigInt, br.ufu.sd.domain.model.BigInt.Builder, br.ufu.sd.core.grpc.abstracts.BigIntOrBuilder> chaveBuilder_;
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     * @return Whether the chave field is set.
     */
    public boolean hasChave() {
      return chaveBuilder_ != null || chave_ != null;
    }
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     * @return The chave.
     */
    public br.ufu.sd.domain.model.BigInt getChave() {
      if (chaveBuilder_ == null) {
        return chave_ == null ? br.ufu.sd.domain.model.BigInt.getDefaultInstance() : chave_;
      } else {
        return chaveBuilder_.getMessage();
      }
    }
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     */
    public Builder setChave(br.ufu.sd.domain.model.BigInt value) {
      if (chaveBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        chave_ = value;
        onChanged();
      } else {
        chaveBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     */
    public Builder setChave(
        br.ufu.sd.domain.model.BigInt.Builder builderForValue) {
      if (chaveBuilder_ == null) {
        chave_ = builderForValue.build();
        onChanged();
      } else {
        chaveBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     */
    public Builder mergeChave(br.ufu.sd.domain.model.BigInt value) {
      if (chaveBuilder_ == null) {
        if (chave_ != null) {
          chave_ =
            br.ufu.sd.domain.model.BigInt.newBuilder(chave_).mergeFrom(value).buildPartial();
        } else {
          chave_ = value;
        }
        onChanged();
      } else {
        chaveBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     */
    public Builder clearChave() {
      if (chaveBuilder_ == null) {
        chave_ = null;
        onChanged();
      } else {
        chave_ = null;
        chaveBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     */
    public BigInt.Builder getChaveBuilder() {
      
      onChanged();
      return getChaveFieldBuilder().getBuilder();
    }
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     */
    public br.ufu.sd.core.grpc.abstracts.BigIntOrBuilder getChaveOrBuilder() {
      if (chaveBuilder_ != null) {
        return chaveBuilder_.getMessageOrBuilder();
      } else {
        return chave_ == null ?
            br.ufu.sd.domain.model.BigInt.getDefaultInstance() : chave_;
      }
    }
    /**
     * <code>.grpc.BigInt chave = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        br.ufu.sd.domain.model.BigInt, br.ufu.sd.domain.model.BigInt.Builder, br.ufu.sd.core.grpc.abstracts.BigIntOrBuilder> 
        getChaveFieldBuilder() {
      if (chaveBuilder_ == null) {
        chaveBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            br.ufu.sd.domain.model.BigInt, br.ufu.sd.domain.model.BigInt.Builder, br.ufu.sd.core.grpc.abstracts.BigIntOrBuilder>(
                getChave(),
                getParentForChildren(),
                isClean());
        chave_ = null;
      }
      return chaveBuilder_;
    }

    private long versao_ ;
    /**
     * <code>int64 versao = 2;</code>
     * @return The versao.
     */
    @java.lang.Override
    public long getVersao() {
      return versao_;
    }
    /**
     * <code>int64 versao = 2;</code>
     * @param value The versao to set.
     * @return This builder for chaining.
     */
    public Builder setVersao(long value) {
      
      versao_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 versao = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearVersao() {
      
      versao_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:grpc.DelVerRequest)
  }

  // @@protoc_insertion_point(class_scope:grpc.DelVerRequest)
  private static final br.ufu.sd.api.contract.request.DelVerRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.ufu.sd.api.contract.request.DelVerRequest();
  }

  public static br.ufu.sd.api.contract.request.DelVerRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DelVerRequest>
      PARSER = new com.google.protobuf.AbstractParser<DelVerRequest>() {
    @java.lang.Override
    public DelVerRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DelVerRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DelVerRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DelVerRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public br.ufu.sd.api.contract.request.DelVerRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

