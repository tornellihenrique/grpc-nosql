package br.ufu.sd.domain.service;

import java.util.List;
import java.util.logging.Logger;

import br.ufu.sd.RouterServer;
import br.ufu.sd.api.contract.reply.*;
import br.ufu.sd.api.contract.request.*;
import br.ufu.sd.core.grpc.NoSqlServiceGrpc.NoSqlServiceImplBase;
import br.ufu.sd.core.ratis.RatisClient;
import br.ufu.sd.domain.model.Exito;
import br.ufu.sd.domain.model.RaftAddressConfig;
import br.ufu.sd.domain.model.Valor;
import io.grpc.stub.StreamObserver;

public class NoSqlServiceImpl extends NoSqlServiceImplBase {

	private static final Logger logger = Logger.getLogger(NoSqlServiceImpl.class.getName());

	private final RatisClient client;

	public NoSqlServiceImpl(String groupUuid, List<RaftAddressConfig> addressConfigList) throws Exception {
		client = new RatisClient(groupUuid, addressConfigList);
	}

	@Override
	public synchronized void set(SetRequest request, StreamObserver<SetReply> responseObserver) {
		SetReply reply = null;
		
		if(!client.containsKey(request.getChave())) {
			
			
			client.set(request.getChave(), Valor.newBuilder()
			               .setObjeto(request.getObjeto())
			               .setVersao(1)
			               .setTimestamp(request.getTimestamp()).build());
			
			reply = SetReply
				.newBuilder()
					.setExito(Exito.SUCCESS)
				    	.build();
		}else {
			
			Valor valorExistente = client.get(request.getChave());
			
			if (valorExistente.getTimestamp() == request.getTimestamp() 
					&& valorExistente.getObjeto().getFieldsMap().equals(request.getObjeto().getFieldsMap())) {
				
				reply = SetReply
						.newBuilder()
							.setExito(Exito.ERROR)
								.setValor(valorExistente)
						    		.build();
			}else {
				
				client.set(request.getChave(),
							Valor.newBuilder(valorExistente)
									.setVersao(valorExistente.getVersao()+1)
									.setTimestamp(request.getTimestamp())
									.setObjeto(request.getObjeto()).build());
				
				reply = SetReply
						.newBuilder()
							.setExito(Exito.SUCCESS)
						    	.build();
			}
			
		}
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	@Override
	public void get(GetRequest request, StreamObserver<GetReply> responseObserver) {
		if (client.containsKey(request.getChave())) {
			responseObserver.onNext(GetReply.newBuilder()
					.setExito(Exito.SUCCESS)
					.setValor(client.get(request.getChave()))
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
	public synchronized void del(DelRequest request, StreamObserver<DelReply> responseObserver) {
		if (client.containsKey(request.getChave())) {
			Valor valor = client.get(request.getChave());

			synchronized (client) {
				client.del(request.getChave());
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
	public synchronized void delVer(DelVerRequest request, StreamObserver<DelVerReply> responseObserver) {
		if (client.containsKey(request.getChave())) {
			Valor valor = client.get(request.getChave());

			if (valor.getVersao() == request.getVersao()) {
				synchronized (client) {
					client.del(request.getChave());
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
	public synchronized void testAndSet(TestAndSetRequest request, StreamObserver<TestAndSetReply> responseObserver) {
		if (client.containsKey(request.getChave())) {
			Valor valor = client.get(request.getChave());

			if (valor.getVersao() == request.getVersao()) {
				Valor newValue = Valor.newBuilder(valor)
						.setVersao(valor.getVersao()+1)
						.setObjeto(request.getObjeto())
						.build();

				synchronized (client) {
					client.set(request.getChave(), newValue);
				}

				responseObserver.onNext(TestAndSetReply.newBuilder()
						.setExito(Exito.SUCCESS)
						.setValor(newValue)
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
}
