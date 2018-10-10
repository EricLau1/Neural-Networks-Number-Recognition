package br.com.eric.data;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.eric.ann.Perceptron;


public class Manager {
	
	@SuppressWarnings("unused")
	private static final String MAIN_COLLECTION = "neurons";
	private static final String TEST_COLLECTION = "neurons_test";

	public static boolean persist(Perceptron p, Integer value) {
		
		if(p.isTrained()) {
			
			MongoDatabase db = Connection.connect();
			
			try {
			
				MongoCollection<Document> collection = db.getCollection(TEST_COLLECTION);
				
				Document doc = new Document("type", "Perceptron");
				doc.append("number", value);
				doc.append("weights", p.getWeights());
				doc.append("bias", p.getBias());
				doc.append("learn_rate", p.getLEARN_RATE());
				doc.append("samples", p.getSamples().size());
				doc.append("trained", p.isTrained());
				doc.append("iterations", p.getIterations());
				doc.append("time_ini", p.getIni().toString());
				doc.append("time_end", p.getEnd().toString());
				
				
				collection.insertOne(doc);
				
				return true;
				
			} catch (MongoException e) {
				
				System.err.println("Error method persist in Manager class.");
				
			}
			
		} else {
			
			System.err.println("Artificial Neural Network is not trained.");
			
		}

		return false;
	}
	

	
	public static boolean remove(String col, Integer target) {

		MongoDatabase db = Connection.connect();

		try {

			MongoCollection<Document> collection = db.getCollection(col);

			Document doc = new Document("target", target);

			collection.deleteOne(doc);

			return true;

		} catch (MongoException e) {

			e.printStackTrace();

		}

		return false;
	}
	
	
}
