package com.latam.ml.solar;

import java.util.HashMap;
import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class RunLoadDataBaseMongo {
		
	public RunLoadDataBaseMongo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
	    try {

		Mongo mongo = new Mongo("localhost", 8081);
		DB db = mongo.getDB("yourdb");

		DBCollection collection = db.getCollection("dummyColl");
		
		// 1. BasicDBObject example
//		System.out.println("BasicDBObject example...");
//		BasicDBObject document = new BasicDBObject();
//		document.put("database", "mkyongDB");
//		document.put("table", "hosting");
//
//		BasicDBObject documentDetail = new BasicDBObject();
//		documentDetail.put("records", 99);
//		documentDetail.put("index", "vps_index1");
//		documentDetail.put("active", "true");
//		document.put("detail", documentDetail);
//
//		collection.insert(document);
//
//		DBCursor cursorDoc = collection.find();
//		while (cursorDoc.hasNext()) {
//			System.out.println(cursorDoc.next());
//		}
//
//		collection.remove(new BasicDBObject());

		// 2. BasicDBObjectBuilder example
//		System.out.println("BasicDBObjectBuilder example...");
//		BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start()
//			.add("database", "mkyongDB")
//	                .add("table", "hosting");
//
//		BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start()
//	                .add("records", "99")
//	                .add("index", "vps_index1")
//			.add("active", "true");
//
//		documentBuilder.add("detail", documentBuilderDetail.get());
//
//		collection.insert(documentBuilder.get());
//
//		DBCursor cursorDocBuilder = collection.find();
//		while (cursorDocBuilder.hasNext()) {
//			System.out.println(cursorDocBuilder.next());
//		}
//
//		collection.remove(new BasicDBObject());

		// 3. Map example
		System.out.println("Map example...");
		Map<String, String> documentMap = new HashMap<String, String>();
		documentMap.put("prueba1", "aaa");
		documentMap.put("prueba2", "bbb");
		documentMap.put("prueba3", "ccc");
		collection.insert(new BasicDBObject(documentMap));

		DBCursor cursorDocMap = collection.find();
		while (cursorDocMap.hasNext()) {
			System.out.println(cursorDocMap.next());
		}

		collection.remove(new BasicDBObject());

		// 4. JSON parse example
//		System.out.println("JSON parse example...");
//
//		String json = "{'database' : 'mkyongDB','table' : 'hosting'," +
//		  "'detail' : {'records' : 99, 'index' : 'vps_index1', 'active' : 'true'}}}";
//
//		DBObject dbObject = (DBObject)JSON.parse(json);
//
//		collection.insert(dbObject);
//
//		DBCursor cursorDocJSON = collection.find();
//		while (cursorDocJSON.hasNext()) {
//			System.out.println(cursorDocJSON.next());
//		}

//		collection.remove(new BasicDBObject());

	    } catch (MongoException ee) {
		ee.printStackTrace();
	    }

	}
}