package br.ufu.sd.domain.service;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;

import br.ufu.sd.api.contract.reply.SetReply;
import br.ufu.sd.api.contract.reply.SetReply.Exito;
import br.ufu.sd.api.contract.request.SetRequest;
import br.ufu.sd.core.grpc.NoSqlServiceGrpc.NoSqlServiceImplBase;
import br.ufu.sd.core.recovery.DatabaseRecovery;
import br.ufu.sd.domain.model.Valor;
import io.grpc.stub.StreamObserver;

public class NoSqlServiceImpl extends NoSqlServiceImplBase {

	private final Map<SetRequest.BigInt, Valor> database;
	private final DatabaseRecovery<SetRequest.BigInt, Valor> databaseRecovery;

	public NoSqlServiceImpl(DatabaseRecovery<SetRequest.BigInt, Valor> databaseRecovery) {
		this.databaseRecovery = databaseRecovery;
		this.database = Collections.synchronizedMap(databaseRecovery.recover());
	}

	@Override
	public void set(SetRequest request, StreamObserver<SetReply> responseObserver) {
		SetReply reply = null;
		
		if(! database.containsKey(request.getKey())) {
			database.put(request.getKey(), Valor.newBuilder()
		               .setObjeto(request.getObjeto())
		               .setVersao(1)
		               .setTimestamp(Instant.now().toEpochMilli()).build());
			
			reply = SetReply
				.newBuilder()
					.setExito(Exito.SUCCESS)
				    	.build();
		}else {
			
			Valor valorExistente = database.get(request.getKey());
			
			if (valorExistente.getTimestamp() == request.getTimestamp() 
					&& valorExistente.getObjeto().getFieldsMap().equals(request.getObjeto().getFieldsMap())) {
				
				reply = SetReply
						.newBuilder()
							.setExito(Exito.ERROR)
								.setValor(valorExistente)
						    		.build();
			}else {
				synchronized (valorExistente) {
					database.put(request.getKey(), 
							Valor.newBuilder(valorExistente).setVersao(valorExistente.getVersao()+1).build());
				}
				
				reply = SetReply
						.newBuilder()
							.setExito(Exito.SUCCESS)
						    	.build();
			}
			
		}
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
		synchronized (databaseRecovery) {
			databaseRecovery.backup(database);
		}
	}

}
