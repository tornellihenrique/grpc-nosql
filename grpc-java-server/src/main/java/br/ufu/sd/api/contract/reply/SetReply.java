// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nosql_database.proto

package br.ufu.sd.api.contract.reply;

import br.ufu.sd.core.grpc.NoSqlServiceProto;
import br.ufu.sd.core.grpc.abstracts.SetReplyOrBuilder;
import br.ufu.sd.domain.model.Valor;

/**
 * Protobuf type {@code grpc.SetReply}
 */
public final class SetReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.SetReply)
    SetReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SetReply.newBuilder() to construct.
  private SetReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SetReply() {
    exito_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SetReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SetReply(
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
            int rawValue = input.readEnum();

            exito_ = rawValue;
            break;
          }
          case 18: {
            br.ufu.sd.domain.model.Valor.Builder subBuilder = null;
            if (valor_ != null) {
              subBuilder = valor_.toBuilder();
            }
            valor_ = input.readMessage(br.ufu.sd.domain.model.Valor.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(valor_);
              valor_ = subBuilder.buildPartial();
            }

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
    return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_SetReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_SetReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.ufu.sd.api.contract.reply.SetReply.class, br.ufu.sd.api.contract.reply.SetReply.Builder.class);
  }

  public static final int EXITO_FIELD_NUMBER = 1;
  private int exito_;
  /**
   * <code>.grpc.Exito exito = 1;</code>
   * @return The enum numeric value on the wire for exito.
   */
  @java.lang.Override public int getExitoValue() {
    return exito_;
  }
  /**
   * <code>.grpc.Exito exito = 1;</code>
   * @return The exito.
   */
  @java.lang.Override public br.ufu.sd.domain.model.Exito getExito() {
    @SuppressWarnings("deprecation")
    br.ufu.sd.domain.model.Exito result = br.ufu.sd.domain.model.Exito.valueOf(exito_);
    return result == null ? br.ufu.sd.domain.model.Exito.UNRECOGNIZED : result;
  }

  public static final int VALOR_FIELD_NUMBER = 2;
  private br.ufu.sd.domain.model.Valor valor_;
  /**
   * <code>.grpc.Valor valor = 2;</code>
   * @return Whether the valor field is set.
   */
  @java.lang.Override
  public boolean hasValor() {
    return valor_ != null;
  }
  /**
   * <code>.grpc.Valor valor = 2;</code>
   * @return The valor.
   */
  @java.lang.Override
  public br.ufu.sd.domain.model.Valor getValor() {
    return valor_ == null ? br.ufu.sd.domain.model.Valor.getDefaultInstance() : valor_;
  }
  /**
   * <code>.grpc.Valor valor = 2;</code>
   */
  @java.lang.Override
  public br.ufu.sd.core.grpc.abstracts.ValorOrBuilder getValorOrBuilder() {
    return getValor();
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
    if (exito_ != br.ufu.sd.domain.model.Exito.ERROR.getNumber()) {
      output.writeEnum(1, exito_);
    }
    if (valor_ != null) {
      output.writeMessage(2, getValor());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (exito_ != br.ufu.sd.domain.model.Exito.ERROR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, exito_);
    }
    if (valor_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getValor());
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
    if (!(obj instanceof br.ufu.sd.api.contract.reply.SetReply)) {
      return super.equals(obj);
    }
    br.ufu.sd.api.contract.reply.SetReply other = (br.ufu.sd.api.contract.reply.SetReply) obj;

    if (exito_ != other.exito_) return false;
    if (hasValor() != other.hasValor()) return false;
    if (hasValor()) {
      if (!getValor()
          .equals(other.getValor())) return false;
    }
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
    hash = (37 * hash) + EXITO_FIELD_NUMBER;
    hash = (53 * hash) + exito_;
    if (hasValor()) {
      hash = (37 * hash) + VALOR_FIELD_NUMBER;
      hash = (53 * hash) + getValor().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.ufu.sd.api.contract.reply.SetReply parseFrom(
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
  public static Builder newBuilder(br.ufu.sd.api.contract.reply.SetReply prototype) {
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
   * Protobuf type {@code grpc.SetReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.SetReply)
      br.ufu.sd.core.grpc.abstracts.SetReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_SetReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_SetReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.ufu.sd.api.contract.reply.SetReply.class, br.ufu.sd.api.contract.reply.SetReply.Builder.class);
    }

    // Construct using br.ufu.sd.core.grpc.SetReply.newBuilder()
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
      exito_ = 0;

      if (valorBuilder_ == null) {
        valor_ = null;
      } else {
        valor_ = null;
        valorBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.ufu.sd.core.grpc.NoSqlServiceProto.internal_static_grpc_SetReply_descriptor;
    }

    @java.lang.Override
    public br.ufu.sd.api.contract.reply.SetReply getDefaultInstanceForType() {
      return br.ufu.sd.api.contract.reply.SetReply.getDefaultInstance();
    }

    @java.lang.Override
    public br.ufu.sd.api.contract.reply.SetReply build() {
      br.ufu.sd.api.contract.reply.SetReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public br.ufu.sd.api.contract.reply.SetReply buildPartial() {
      br.ufu.sd.api.contract.reply.SetReply result = new br.ufu.sd.api.contract.reply.SetReply(this);
      result.exito_ = exito_;
      if (valorBuilder_ == null) {
        result.valor_ = valor_;
      } else {
        result.valor_ = valorBuilder_.build();
      }
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
      if (other instanceof br.ufu.sd.api.contract.reply.SetReply) {
        return mergeFrom((br.ufu.sd.api.contract.reply.SetReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.ufu.sd.api.contract.reply.SetReply other) {
      if (other == br.ufu.sd.api.contract.reply.SetReply.getDefaultInstance()) return this;
      if (other.exito_ != 0) {
        setExitoValue(other.getExitoValue());
      }
      if (other.hasValor()) {
        mergeValor(other.getValor());
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
      br.ufu.sd.api.contract.reply.SetReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.ufu.sd.api.contract.reply.SetReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int exito_ = 0;
    /**
     * <code>.grpc.Exito exito = 1;</code>
     * @return The enum numeric value on the wire for exito.
     */
    @java.lang.Override public int getExitoValue() {
      return exito_;
    }
    /**
     * <code>.grpc.Exito exito = 1;</code>
     * @param value The enum numeric value on the wire for exito to set.
     * @return This builder for chaining.
     */
    public Builder setExitoValue(int value) {
      
      exito_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Exito exito = 1;</code>
     * @return The exito.
     */
    @java.lang.Override
    public br.ufu.sd.domain.model.Exito getExito() {
      @SuppressWarnings("deprecation")
      br.ufu.sd.domain.model.Exito result = br.ufu.sd.domain.model.Exito.valueOf(exito_);
      return result == null ? br.ufu.sd.domain.model.Exito.UNRECOGNIZED : result;
    }
    /**
     * <code>.grpc.Exito exito = 1;</code>
     * @param value The exito to set.
     * @return This builder for chaining.
     */
    public Builder setExito(br.ufu.sd.domain.model.Exito value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      exito_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.Exito exito = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearExito() {
      
      exito_ = 0;
      onChanged();
      return this;
    }

    private br.ufu.sd.domain.model.Valor valor_;
    private com.google.protobuf.SingleFieldBuilderV3<
        br.ufu.sd.domain.model.Valor, br.ufu.sd.domain.model.Valor.Builder, br.ufu.sd.core.grpc.abstracts.ValorOrBuilder> valorBuilder_;
    /**
     * <code>.grpc.Valor valor = 2;</code>
     * @return Whether the valor field is set.
     */
    public boolean hasValor() {
      return valorBuilder_ != null || valor_ != null;
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     * @return The valor.
     */
    public br.ufu.sd.domain.model.Valor getValor() {
      if (valorBuilder_ == null) {
        return valor_ == null ? br.ufu.sd.domain.model.Valor.getDefaultInstance() : valor_;
      } else {
        return valorBuilder_.getMessage();
      }
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    public Builder setValor(br.ufu.sd.domain.model.Valor value) {
      if (valorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        valor_ = value;
        onChanged();
      } else {
        valorBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    public Builder setValor(
        br.ufu.sd.domain.model.Valor.Builder builderForValue) {
      if (valorBuilder_ == null) {
        valor_ = builderForValue.build();
        onChanged();
      } else {
        valorBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    public Builder mergeValor(br.ufu.sd.domain.model.Valor value) {
      if (valorBuilder_ == null) {
        if (valor_ != null) {
          valor_ =
            br.ufu.sd.domain.model.Valor.newBuilder(valor_).mergeFrom(value).buildPartial();
        } else {
          valor_ = value;
        }
        onChanged();
      } else {
        valorBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    public Builder clearValor() {
      if (valorBuilder_ == null) {
        valor_ = null;
        onChanged();
      } else {
        valor_ = null;
        valorBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    public Valor.Builder getValorBuilder() {
      
      onChanged();
      return getValorFieldBuilder().getBuilder();
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    public br.ufu.sd.core.grpc.abstracts.ValorOrBuilder getValorOrBuilder() {
      if (valorBuilder_ != null) {
        return valorBuilder_.getMessageOrBuilder();
      } else {
        return valor_ == null ?
            br.ufu.sd.domain.model.Valor.getDefaultInstance() : valor_;
      }
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        br.ufu.sd.domain.model.Valor, br.ufu.sd.domain.model.Valor.Builder, br.ufu.sd.core.grpc.abstracts.ValorOrBuilder> 
        getValorFieldBuilder() {
      if (valorBuilder_ == null) {
        valorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            br.ufu.sd.domain.model.Valor, br.ufu.sd.domain.model.Valor.Builder, br.ufu.sd.core.grpc.abstracts.ValorOrBuilder>(
                getValor(),
                getParentForChildren(),
                isClean());
        valor_ = null;
      }
      return valorBuilder_;
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


    // @@protoc_insertion_point(builder_scope:grpc.SetReply)
  }

  // @@protoc_insertion_point(class_scope:grpc.SetReply)
  private static final br.ufu.sd.api.contract.reply.SetReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.ufu.sd.api.contract.reply.SetReply();
  }

  public static br.ufu.sd.api.contract.reply.SetReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SetReply>
      PARSER = new com.google.protobuf.AbstractParser<SetReply>() {
    @java.lang.Override
    public SetReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SetReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SetReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SetReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public br.ufu.sd.api.contract.reply.SetReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

