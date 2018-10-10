package br.com.eric.data;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import br.com.eric.ann.Perceptron;

public class Store {

	private static final String MAIN_COLLECTION = "neurons";
	private static final String TEST_COLLECTION = "neurons_test"; // mude para "neurons_test" para fazer testes
	
	private static final String[] selected = {MAIN_COLLECTION, TEST_COLLECTION};

	@SuppressWarnings("unchecked")
	public static List<Perceptron> findAll() {
		
		List<Perceptron> lst = new ArrayList<>();
		
		MongoDatabase db = Connection.connect();
		
		try {
		
			MongoCollection<Document> collection = db.getCollection(TEST_COLLECTION);
			
			Document search = new Document("type", "Perceptron");
			
			MongoCursor<Document> iterator = collection.find(search).iterator();
			
			
			while(iterator.hasNext()) {
				
				Document found = iterator.next();
				
				Perceptron p = new Perceptron();
				
				p.setTarget(found.getInteger("number"));
				p.setW(found.get("weights", List.class));
				p.setB(found.getDouble("bias"));
				p.setTrained(found.getBoolean("trained"));
				
				lst.add(p);
			}
			
			iterator.close();
			
			return lst;
			
		} catch (MongoException e) {
			
			System.err.println("Error data read.");
			
		}

		return null;
	}

	
	@SuppressWarnings("unchecked")
	public static List<Perceptron> findAll(int option) {
		
		if(Math.abs(option) > 1) {
			option = 1;
		}
		
		String select = selected[option];
		
		List<Perceptron> lst = new ArrayList<>();
		
		MongoDatabase db = Connection.connect();
		
		try {
		
			MongoCollection<Document> collection = db.getCollection(select);
			
			Document search = new Document("type", "Perceptron");
			
			MongoCursor<Document> iterator = collection.find(search).iterator();
			
			
			while(iterator.hasNext()) {
				
				Document found = iterator.next();
				
				Perceptron p = new Perceptron();
				
				p.setTarget(found.getInteger("number"));
				p.setW(found.get("weights", List.class));
				p.setB(found.getDouble("bias"));
				p.setTrained(found.getBoolean("trained"));
				
				lst.add(p);
			}
			
			iterator.close();
			
		} catch (MongoException e) {
			
			System.err.println("Error data read.");
			
		}

		return lst;
	}

	public static boolean dropAll() {
		
		MongoDatabase db = Connection.connect();
		
		try {
			
			MongoCollection<Document> collection = db.getCollection(TEST_COLLECTION);
			
			collection.drop();
			
			return true;
			
		} catch (MongoException e) {
			
			System.err.println("Error data drop.");
			
		}
		return false;
	}
}
