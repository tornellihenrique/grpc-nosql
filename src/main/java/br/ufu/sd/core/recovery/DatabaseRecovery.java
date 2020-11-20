package br.ufu.sd.core.recovery;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class DatabaseRecovery<K,V> {

	private final File backupFile;
	
	
	public DatabaseRecovery(String backupFilePath) {
		this.backupFile = new File(backupFilePath);
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<K,V> recover(){
		Map<K,V> map = null;
		// Deserialization 
		try {
		  // Reading the object from a file
		  System.out.println("Recuperacao da base de dados NoSQL via backup..");
		  FileInputStream file = new FileInputStream(backupFile.getAbsolutePath()); 
		  ObjectInputStream in = new ObjectInputStream(file); 
		  // Method for deserialization of object 
		  map = (Map<K,V>) in.readObject(); 
		  in.close(); 
		  file.close(); 
		  System.out.println("Recuperacao da base de dados NoSQL realizada com sucesso");
		  return map;
		} catch(IOException ex) { 
			System.out.println("Erro ao recuperar o backup da base de dados NoSQL. Caminho do arquivo de backup : " + backupFile.getAbsolutePath());
		} catch(ClassNotFoundException ex) { 
		  System.out.println("Classe realizavel nao encontrada!"); 
		}
		return map;
	}
	
	public void backup(Map<?, ?> map){
		// Serialization  
		try {    
		  //Saving of object in a file 
		  System.out.println("Fazendo backup da base de dados NoSQL..."); 
		  FileOutputStream file = new FileOutputStream(backupFile.getAbsolutePath()); 
		  ObjectOutputStream out = new ObjectOutputStream(file); 
		  // Method for serialization of object 
		  out.writeObject(map); 
		  out.close(); 
		  file.close(); 
		  System.out.println("Backup da base de dados NoSQL realizada com sucesso"); 
		} catch(IOException ex) { 
		  System.out.println("Erro ao gerar o backup da base de dados NoSQL. Caminho do arquivo de backup : " + backupFile.getAbsolutePath()); 
		}
	}
}


