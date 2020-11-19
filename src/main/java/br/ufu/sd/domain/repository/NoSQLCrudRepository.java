package br.ufu.sd.domain.repository;

import java.math.BigInteger;

import br.ufu.sd.core.grpc.model.Objeto;
import br.ufu.sd.core.grpc.model.ObjetoConsultado;


public interface NoSQLCrudRepository {

	ObjetoConsultado set(BigInteger key, Long timestamp, Objeto o);
	
}
