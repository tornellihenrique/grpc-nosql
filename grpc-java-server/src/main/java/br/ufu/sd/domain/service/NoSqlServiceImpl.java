package br.ufu.sd.domain.service;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;

import br.ufu.sd.api.contract.reply.SetReply;
import br.ufu.sd.api.contract.request.SetRequest;
import br.ufu.sd.core.grpc.NoSqlServiceGrpc.NoSqlServiceImplBase;
import br.ufu.sd.core.recovery.DatabaseRecovery;
import br.ufu.sd.domain.model.BigInt;
import br.ufu.sd.domain.model.Exito;
import br.ufu.sd.domain.model.Valor;
import io.grpc.stub.StreamObserver;

public class NoSqlServiceImpl extends NoSqlServiceImplBase {

	private final Map<BigInt, Valor> database;
	private final DatabaseRecovery<BigInt, Valor> databaseRecovery;
	

	public NoSqlServiceImpl(DatabaseRecovery<BigInt, Valor> databaseRecovery) {
		this.databaseRecovery = databaseRecovery;
		this.database = Collections.synchronizedMap(databaseRecovery.recover());
	}

	@Override
	public void set(SetRequest request, StreamObserver<SetReply> responseObserver) {
		SetReply reply = null;
		
		if(! database.containsKey(request.getChave())) {
			database.put(request.getChave(), Valor.newBuilder()
		               .setObjeto(request.getObjeto())
		               .setVersao(1)
		               .setTimestamp(Instant.now().toEpochMilli()).build());
			
			reply = SetReply
				.newBuilder()
					.setExito(Exito.SUCCESS)
				    	.build();
		}else {
			
			Valor valorExistente = database.get(request.getChave());
			
			if (valorExistente.getTimestamp() == request.getTimestamp() 
					&& valorExistente.getObjeto().getFieldsMap().equals(request.getObjeto().getFieldsMap())) {
				
				reply = SetReply
						.newBuilder()
							.setExito(Exito.ERROR)
								.setValor(valorExistente)
						    		.build();
			}else {
				synchronized (valorExistente) {
					database.put(request.getChave(), 
							Valor.newBuilder(valorExistente).setVersao(valorExistente.getVersao()+1).setObjeto(request.getObjeto()).build());
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
