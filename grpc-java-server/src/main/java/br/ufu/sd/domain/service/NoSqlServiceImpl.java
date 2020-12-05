package br.ufu.sd.domain.service;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;

import br.ufu.sd.api.contract.reply.*;
import br.ufu.sd.api.contract.request.*;
import br.ufu.sd.core.grpc.NoSqlServiceGrpc.NoSqlServiceImplBase;
import br.ufu.sd.core.maintenance.DatabaseMaintenance;
import br.ufu.sd.domain.model.BigInt;
import br.ufu.sd.domain.model.Exito;
import br.ufu.sd.domain.model.Valor;
import io.grpc.stub.StreamObserver;

public class NoSqlServiceImpl extends NoSqlServiceImplBase {

	private final Map<BigInt, Valor> database;
	private final DatabaseMaintenance<BigInt, Valor> databaseRecovery;
	

	public NoSqlServiceImpl(DatabaseMaintenance<BigInt, Valor> databaseRecovery) {
		this.databaseRecovery = databaseRecovery;
		this.database = databaseRecovery.recover();
	}

	@Override
	public synchronized void set(SetRequest request, StreamObserver<SetReply> responseObserver) {
		SetReply reply = null;
		
		if(! database.containsKey(request.getChave())) {
			database.put(request.getChave(), Valor.newBuilder()
		               .setObjeto(request.getObjeto())
		               .setVersao(1)
		               .setTimestamp(request.getTimestamp()).build());
			
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
				synchronized (database) {
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

	@Override
	public void get(GetRequest request, StreamObserver<GetReply> responseObserver) {
		if (database.containsKey(request.getChave())) {
			responseObserver.onNext(GetReply.newBuilder()
					.setExito(Exito.SUCCESS)
					.setValor(database.get(request.getChave()))
					.build());
			responseObserver.onCompleted();

			return;
		}

		responseObserver.onNext(GetReply.newBuilder()
				.setExito(Exito.ERROR)
				.build());
		responseObserver.onCompleted();
	}

	@Override
	public void del(DelRequest request, StreamObserver<DelReply> responseObserver) {
		if (database.containsKey(request.getChave())) {
			Valor valor = database.get(request.getChave());

			synchronized (database) {
				database.remove(request.getChave());
			}

			responseObserver.onNext(DelReply.newBuilder()
					.setExito(Exito.SUCCESS)
					.setValor(valor)
					.build());
			responseObserver.onCompleted();

			return;
		}

		responseObserver.onNext(DelReply.newBuilder()
				.setExito(Exito.ERROR)
				.build());
		responseObserver.onCompleted();
	}

	@Override
	public void delVer(DelVerRequest request, StreamObserver<DelVerReply> responseObserver) {
		if (database.containsKey(request.getChave())) {
			Valor valor = database.get(request.getChave());

			if (valor.getVersao() == request.getVersao()) {
				synchronized (database) {
					database.remove(request.getChave());
				}

				responseObserver.onNext(DelVerReply.newBuilder()
						.setExito(Exito.SUCCESS)
						.setValor(valor)
						.build());
			} else {
				responseObserver.onNext(DelVerReply.newBuilder()
						.setExito(Exito.ERROR_WV)
						.setValor(valor)
						.build());
			}

			responseObserver.onCompleted();

			return;
		}

		responseObserver.onNext(DelVerReply.newBuilder()
				.setExito(Exito.ERROR_NE)
				.build());
		responseObserver.onCompleted();
	}

	@Override
	public void testAndSet(TestAndSetRequest request, StreamObserver<TestAndSetReply> responseObserver) {
		if (database.containsKey(request.getChave())) {
			Valor valor = database.get(request.getChave());

			if (valor.getVersao() == request.getVersao()) {
				synchronized (database) {
					database.put(request.getChave(), Valor.newBuilder(valor)
							.setVersao(valor.getVersao())
							.setObjeto(request.getObjeto())
							.build());
				}

				responseObserver.onNext(TestAndSetReply.newBuilder()
						.setExito(Exito.SUCCESS)
						.setValor(valor)
						.build());
			} else {
				responseObserver.onNext(TestAndSetReply.newBuilder()
						.setExito(Exito.ERROR_WV)
						.setValor(valor)
						.build());
			}

			responseObserver.onCompleted();

			return;
		}

		responseObserver.onNext(TestAndSetReply.newBuilder()
				.setExito(Exito.ERROR_NE)
				.build());
		responseObserver.onCompleted();
	}
	
	public Map<BigInt, Valor> getDatabase(){
		return database;
	}
}
