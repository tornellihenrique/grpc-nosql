// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nosql_database.proto

package br.ufu.sd.core.grpc.abstracts;

import br.ufu.sd.domain.model.BigInt;

public interface DelVerRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.DelVerRequest)
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
   * <code>int64 versao = 2;</code>
   * @return The versao.
   */
  long getVersao();
}
