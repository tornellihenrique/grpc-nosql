// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nosql_database.proto

package br.ufu.sd.core.grpc.abstracts;

import br.ufu.sd.domain.model.Exito;
import br.ufu.sd.domain.model.Valor;

public interface GetReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.GetReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.grpc.Exito exito = 1;</code>
   * @return The enum numeric value on the wire for exito.
   */
  int getExitoValue();
  /**
   * <code>.grpc.Exito exito = 1;</code>
   * @return The exito.
   */
  br.ufu.sd.domain.model.Exito getExito();

  /**
   * <code>.grpc.Valor valor = 2;</code>
   * @return Whether the valor field is set.
   */
  boolean hasValor();
  /**
   * <code>.grpc.Valor valor = 2;</code>
   * @return The valor.
   */
  Valor getValor();
  /**
   * <code>.grpc.Valor valor = 2;</code>
   */
  ValorOrBuilder getValorOrBuilder();
}
