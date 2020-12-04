// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nosql_database.proto

package br.ufu.sd.api.contract.reply;

import br.ufu.sd.core.grpc.NoSqlServiceProto;
import br.ufu.sd.core.grpc.abstracts.GetReplyOrBuilder;
import br.ufu.sd.domain.model.Valor;

/**
 * Protobuf type {@code grpc.GetReply}
 */
public final class GetReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.GetReply)
    GetReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetReply.newBuilder() to construct.
  private GetReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetReply() {
    exito_ = 0;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetReply();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
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
            Valor.Builder subBuilder = null;
            if (valor_ != null) {
              subBuilder = valor_.toBuilder();
            }
            valor_ = input.readMessage(Valor.parser(), extensionRegistry);
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
    return NoSqlServiceProto.internal_static_grpc_GetReply_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return NoSqlServiceProto.internal_static_grpc_GetReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GetReply.class, Builder.class);
  }

  public static final int EXITO_FIELD_NUMBER = 1;
  private int exito_;
  /**
   * <code>.grpc.Exito exito = 1;</code>
   * @return The enum numeric value on the wire for exito.
   */
  @Override public int getExitoValue() {
    return exito_;
  }
  /**
   * <code>.grpc.Exito exito = 1;</code>
   * @return The exito.
   */
  @Override public br.ufu.sd.domain.model.Exito getExito() {
    @SuppressWarnings("deprecation")
    br.ufu.sd.domain.model.Exito result = br.ufu.sd.domain.model.Exito.valueOf(exito_);
    return result == null ? br.ufu.sd.domain.model.Exito.UNRECOGNIZED : result;
  }

  public static final int VALOR_FIELD_NUMBER = 2;
  private Valor valor_;
  /**
   * <code>.grpc.Valor valor = 2;</code>
   * @return Whether the valor field is set.
   */
  @Override
  public boolean hasValor() {
    return valor_ != null;
  }
  /**
   * <code>.grpc.Valor valor = 2;</code>
   * @return The valor.
   */
  @Override
  public Valor getValor() {
    return valor_ == null ? Valor.getDefaultInstance() : valor_;
  }
  /**
   * <code>.grpc.Valor valor = 2;</code>
   */
  @Override
  public br.ufu.sd.core.grpc.abstracts.ValorOrBuilder getValorOrBuilder() {
    return getValor();
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
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

  @Override
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

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof GetReply)) {
      return super.equals(obj);
    }
    GetReply other = (GetReply) obj;

    if (exito_ != other.exito_) return false;
    if (hasValor() != other.hasValor()) return false;
    if (hasValor()) {
      if (!getValor()
          .equals(other.getValor())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
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

  public static GetReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static GetReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(GetReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.GetReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.GetReply)
      br.ufu.sd.core.grpc.abstracts.GetReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return NoSqlServiceProto.internal_static_grpc_GetReply_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return NoSqlServiceProto.internal_static_grpc_GetReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetReply.class, Builder.class);
    }

    // Construct using br.ufu.sd.core.grpc.GetReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
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

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return NoSqlServiceProto.internal_static_grpc_GetReply_descriptor;
    }

    @Override
    public GetReply getDefaultInstanceForType() {
      return GetReply.getDefaultInstance();
    }

    @Override
    public GetReply build() {
      GetReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public GetReply buildPartial() {
      GetReply result = new GetReply(this);
      result.exito_ = exito_;
      if (valorBuilder_ == null) {
        result.valor_ = valor_;
      } else {
        result.valor_ = valorBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof GetReply) {
        return mergeFrom((GetReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GetReply other) {
      if (other == GetReply.getDefaultInstance()) return this;
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

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      GetReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (GetReply) e.getUnfinishedMessage();
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
    @Override public int getExitoValue() {
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
    @Override
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

    private Valor valor_;
    private com.google.protobuf.SingleFieldBuilderV3<
        Valor, Valor.Builder, br.ufu.sd.core.grpc.abstracts.ValorOrBuilder> valorBuilder_;
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
    public Valor getValor() {
      if (valorBuilder_ == null) {
        return valor_ == null ? Valor.getDefaultInstance() : valor_;
      } else {
        return valorBuilder_.getMessage();
      }
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    public Builder setValor(Valor value) {
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
        Valor.Builder builderForValue) {
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
    public Builder mergeValor(Valor value) {
      if (valorBuilder_ == null) {
        if (valor_ != null) {
          valor_ =
            Valor.newBuilder(valor_).mergeFrom(value).buildPartial();
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
            Valor.getDefaultInstance() : valor_;
      }
    }
    /**
     * <code>.grpc.Valor valor = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Valor, Valor.Builder, br.ufu.sd.core.grpc.abstracts.ValorOrBuilder>
        getValorFieldBuilder() {
      if (valorBuilder_ == null) {
        valorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Valor, Valor.Builder, br.ufu.sd.core.grpc.abstracts.ValorOrBuilder>(
                getValor(),
                getParentForChildren(),
                isClean());
        valor_ = null;
      }
      return valorBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.GetReply)
  }

  // @@protoc_insertion_point(class_scope:grpc.GetReply)
  private static final GetReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetReply();
  }

  public static GetReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetReply>
      PARSER = new com.google.protobuf.AbstractParser<GetReply>() {
    @Override
    public GetReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetReply> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetReply> getParserForType() {
    return PARSER;
  }

  @Override
  public GetReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

