package br.ufu.sd.core.maintenance;

import java.util.Map;
import java.util.TimerTask;

import br.ufu.sd.domain.model.BigInt;
import br.ufu.sd.domain.model.Valor;

public class DatabaseBackupTask extends TimerTask{

	private final Map<BigInt, Valor> database;
	private final DatabaseMaintenance<BigInt, Valor> databaseMaintenanceBean;
	
	public DatabaseBackupTask(Map<BigInt,Valor> database, DatabaseMaintenance<BigInt, Valor> databaseMaintenanceBean) {
		this.database = database;
		this.databaseMaintenanceBean = databaseMaintenanceBean;
	}
	
	
	@Override
	public void run() {
		// segurando o banco de dados até que a tarefa de manutenção seja completada
		synchronized (database) {
			databaseMaintenanceBean.backup(database);
		}
		
	}

}
