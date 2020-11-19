package br.ufu.sd.domain.service;

import java.math.BigInteger;

import br.ufu.sd.api.contract.reply.SalvarReply;
import br.ufu.sd.api.contract.request.SalvarRequest;
import br.ufu.sd.core.grpc.NoSqlServiceGrpc.NoSqlServiceImplBase;
import br.ufu.sd.core.grpc.model.Objeto;
import br.ufu.sd.domain.repository.NoSQLCrudRepository;
import io.grpc.stub.StreamObserver;

public class NoSqlServiceImpl extends NoSqlServiceImplBase{
	
	private NoSQLCrudRepository repositorioNoSql;
	
	public NoSqlServiceImpl(NoSQLCrudRepository repositorioNoSql) {
		this.repositorioNoSql = repositorioNoSql;
	}
	
   
   @Override
   public void salvar(SalvarRequest req, StreamObserver<SalvarReply> responseObserver) {
	 BigInteger reqKey = new BigInteger(req.getKey().getValue().toByteArray());
	 Objeto reqObject = req.getObject();
	 Long reqTimestamp = req.getTimestamp().getValue();
	 
//	 reqObject.getType()
	 
		 SalvarReply reply = SalvarReply.newBuilder().build();
     responseObserver.onNext(reply);
     responseObserver.onCompleted();
   }
   
}
