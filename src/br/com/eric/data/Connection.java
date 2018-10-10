package br.com.eric.data;

/* 
 * Site do MongoDB:
 * 
 * 	https://www.mongodb.com/
 * 
 * P�s Instala��o:
 * 
 * 	1� - Criar um diretorio no C: chamado "data"
 *  2� - Acessar o diretorio de instala��o do MongoDB
 *  3� - Executar o "mongod.exe" que executa o servidor
 *  4� - Executar o "mongo.exe" que executa o cliente
 * 
 * Download do mongo java driver:
 * 
 * 	https://mongodb.github.io/mongo-java-driver/
 * 
 * Driver adicionado ao diretorio lib
 * 
 * Apontar o build path para o driver
 * 
 * */

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

public class Connection {

	private static MongoClient client = null;
	
	private static final String HOST = "localhost";
	private static final String DBNAME = "ann_data";
	private static final Integer PORT = 27017;
	
	public static MongoDatabase connect() {
		
		
		try {
		
			client = new MongoClient(HOST, PORT);
			
			return client.getDatabase(DBNAME);
			
			
		} catch (MongoException e) {
			
			client.close();
			
			System.err.println("Um erro aconteceu na conex�o.");
			
		} 
		
		return null;
	}
}
