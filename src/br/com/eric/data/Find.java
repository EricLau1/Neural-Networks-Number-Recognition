package br.com.eric.data;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import br.com.eric.ann.TrainingSet;

public class Find {

	
	@SuppressWarnings("unchecked")
	public static List<TrainingSet> getSamples(String col, Integer number) {

		MongoDatabase db = Connection.connect();

		Document search = new Document("number", number);
		
		try {

			MongoCollection<Document> collection = db.getCollection(col);

			Document found = null;
			
			MongoCursor<Document> iterator = collection.find(search).iterator();
			
			List<TrainingSet> lst = new ArrayList<>();
			
			while (iterator.hasNext()) {

				found = iterator.next();
				
				TrainingSet samples = new TrainingSet();
				
				samples.setInput(found.get("input", List.class));
				samples.setOutput(found.getInteger("output"));
				
				lst.add(samples);
				
			}
			
			return lst;
			
		} catch (MongoException e) {

			System.err.println("Um erro ocorreu com o banco de dados."
					+ " Verifique se o servidor \"mongod\" foi iniciado.");
			
		}
		return null;
	}
	
}
