package br.ufu.sd.bootstrap.database;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ufu.sd.core.maintenance.DatabaseMaintenance;
import br.ufu.sd.domain.model.BigInt;
import br.ufu.sd.domain.model.Valor;

public class HashDatabaseRecoveryBeanTestSuit {

	private static DatabaseMaintenance<BigInt, Valor> databaseRecoveryBean;
	
	@BeforeClass
	public static void prepararBeanParaRecuperacaoDeDatabase() {
		databaseRecoveryBean = new DatabaseMaintenance<BigInt,Valor>(
				(System.getProperty("user.dir") 
				+ File.separatorChar + "src" 
				+ File.separatorChar + "main" 
				+ File.separatorChar + "resources" 
				+ File.separatorChar + "db" 
				+ File.separatorChar + "nosql_database2.backup"));
	}
	
	@Test
	public void seEuSalvarERecuperarOMesmoMapa_Entao_TereiUmMapaComMesmosValores() {
		Map<BigInt, Valor> testMapToBackup = new HashMap<>();
//		testMapToBackup.put("Nome", "Davide");
//		testMapToBackup.put("Sobrenome", "Sgalambro");
		
		
//		testMapToBackup.clear();
		
		testMapToBackup = databaseRecoveryBean.recover();
		
//		assertTrue(testMapToBackup.get("Nome").contentEquals("Davide"));
//		assertTrue(testMapToBackup.get("Sobrenome").contentEquals("Sgalambro"));
		
		System.out.println(testMapToBackup);
		
	}

}
