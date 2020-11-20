package br.ufu.sd.bootstrap.database;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ufu.sd.core.recovery.DatabaseRecovery;

public class HashDatabaseRecoveryBeanTestSuit {

	private static DatabaseRecovery<String, String> databaseRecoveryBean;
	
	@BeforeClass
	public static void prepararBeanParaRecuperacaoDeDatabase() {
		databaseRecoveryBean = new DatabaseRecovery<String,String>(
				(System.getProperty("user.dir") 
				+ File.separatorChar + "src" 
				+ File.separatorChar + "main" 
				+ File.separatorChar + "resources" 
				+ File.separatorChar + "db" 
				+ File.separatorChar + "nosql_database.backup"));
	}
	
	@Test
	public void seEuSalvarERecuperarOMesmoMapa_Entao_TereiUmMapaComMesmosValores() {
		Map<String, String> testMapToBackup = new HashMap<>();
		testMapToBackup.put("Nome", "Davide");
		testMapToBackup.put("Sobrenome", "Sgalambro");
		
		databaseRecoveryBean.backup(testMapToBackup);
		
		testMapToBackup.clear();
		
		testMapToBackup = databaseRecoveryBean.recover();
		
		assertTrue(testMapToBackup.get("Nome").contentEquals("Davide"));
		assertTrue(testMapToBackup.get("Sobrenome").contentEquals("Sgalambro"));
		
	}

}
