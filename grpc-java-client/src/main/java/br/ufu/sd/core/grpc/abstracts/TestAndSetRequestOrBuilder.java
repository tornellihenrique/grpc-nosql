// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nosql_database.proto

package br.ufu.sd.core.grpc.abstracts;

import br.ufu.sd.domain.model.BigInt;

public interface TestAndSetRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.TestAndSetRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.grpc.BigInt chave = 1;</code>
   * @return Whether the chave field is set.
   */
  boolean hasChave();
  /**
   * <code>.grpc.BigInt chave = 1;</code>
   * @return The chave.
   */
  br.ufu.sd.domain.model.BigInt getChave();
  /**
   * <code>.grpc.BigInt chave = 1;</code>
   */
  BigIntOrBuilder getChaveOrBuilder();

  /**
   * <code>int64 timestamp = 2;</code>
   * @return The timestamp.
   */
  long getTimestamp();

  /**
   * <code>.google.protobuf.Struct objeto = 3;</code>
   * @return Whether the objeto field is set.
   */
  boolean hasObjeto();
  /**
   * <code>.google.protobuf.Struct objeto = 3;</code>
   * @return The objeto.
   */
  com.google.protobuf.Struct getObjeto();
  /**
   * <code>.google.protobuf.Struct objeto = 3;</code>
   */
  com.google.protobuf.StructOrBuilder getObjetoOrBuilder();

  /**
   * <code>int64 versao = 4;</code>
   * @return The versao.
   */
  long getVersao();
}
