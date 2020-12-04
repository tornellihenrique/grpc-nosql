package br.ufu.sd.core.recovery;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import br.ufu.sd.domain.service.NoSqlServiceImpl;

public class DatabaseRecovery<K,V> {

	private final File backupFile;
	private static final Logger logger = Logger.getLogger(NoSqlServiceImpl.class.getName());
	
	public DatabaseRecovery(String backupFilePath) {
		this.backupFile = new File(backupFilePath);
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<K,V> recover(){
		Map<K,V> map = null;
		// Deserialization 
		try {
		  // Reading the object from a file
		  logger.info("Recuperacao da base de dados NoSQL via backup..");
		  ObjectInputStream in = null;
		  try {
			  FileInputStream file = new FileInputStream(backupFile.getAbsolutePath());
			  in = new ObjectInputStream(file);

			  // Method for deserialization of object
			  map = (Map<K,V>) in.readObject();
			  in.close();
			  file.close();
		  }catch(EOFException exc) { // se o arquivo for vazio, retorne um HashMap vazia
			  logger.info("Recuperacao da base de dados NoSQL realizada com sucesso");
			  return new HashMap<>();
		  }
		  logger.info("Recuperacao da base de dados NoSQL realizada com sucesso");
		  return map == null ? new HashMap<>() : map;
		} catch(IOException ex) {
		  logger.warning("Erro ao recuperar o backup da base de dados NoSQL. Caminho do arquivo de backup : " + backupFile.getAbsolutePath());
		} catch(ClassNotFoundException ex) {
		  logger.warning("Classe realizavel nao encontrada!");
		}
		return map;
	}
	
	public void backup(Map<?, ?> map){
		// Serialization  
		try {    
		  //Saving of object in a file
		  logger.info("Fazendo backup da base de dados NoSQL...");
		  FileOutputStream file = new FileOutputStream(backupFile.getAbsolutePath()); 
		  ObjectOutputStream out = new ObjectOutputStream(file); 
		  // Method for serialization of object 
		  out.writeObject(map); 
		  out.close(); 
		  file.close(); 
		  logger.info("Backup da base de dados NoSQL realizada com sucesso");
		} catch(IOException ex) {
		  logger.warning("Erro ao gerar o backup da base de dados NoSQL. Caminho do arquivo de backup : " + backupFile.getAbsolutePath());
		}
	}
}


