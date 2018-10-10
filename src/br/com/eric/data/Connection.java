package br.com.eric.data;

/* 
 * Site do MongoDB:
 * 
 * 	https://www.mongodb.com/
 * 
 * Pós Instalação:
 * 
 * 	1º - Criar um diretorio no C: chamado "data"
 *  2º - Acessar o diretorio de instalação do MongoDB
 *  3º - Executar o "mongod.exe" que executa o servidor
 *  4º - Executar o "mongo.exe" que executa o cliente
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
			
			System.err.println("Um erro aconteceu na conexão.");
			
		} 
		
		return null;
	}
}
