package com.latam.ml.solar;

import java.util.HashMap;
import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoURI;

public class RunSolarSystemDB {
	
	public static void main(String[] args) {
		
		Galaxy galaxy = new Galaxy(Weather.SEQUIA);

		Planet beta = new Planet("BETA",2000, -3);
		Planet ferengi = new Planet("FERENGI",500, -1);		
		Planet vulcano = new Planet("VULCANO",1000, 5);
		
		galaxy.getPlanetas().add(beta);
		galaxy.getPlanetas().add(ferengi);
		galaxy.getPlanetas().add(vulcano);
		
		Weather dayW = Weather.SEQUIA;
		
		//Mongo mongo = new Mongo("localhost", 27017);
		String textUri = "mongodb://martino.:martino@ds147995.mlab.com:47995/myclouddb";
		MongoURI uri = new MongoURI(textUri);
		Mongo m = new Mongo(uri);
		
		DB db = m.getDB("solardatabase");
		DBCollection collection = db.getCollection("weather");
		
		//
		//ESCRIBIR VALORES EN COLLECTION
		//
		
		//3600 means 10 years
		for(int d=0; d<3650;d++){
			galaxy.setPositionByDay(d);
			
			if(galaxy.arePlanetsAligned()){
				if(galaxy.arePlanetsAlignedToSun())
					dayW= Weather.SEQUIA;
				else
					dayW= Weather.COND_OPTIMAS;	
			}else if(galaxy.isTheSunInTheArea()){			
				dayW= Weather.LLUVIA;
			}else{
				dayW= Weather.INESTABLE;
			}
//			System.out.println(String.valueOf(d)+" "+dayW);
			
			Map<String, String> documentMap = new HashMap<String, String>();
			for(Planet pla:galaxy.getPlanetas()){
				documentMap.put(pla.getName(),pla.getPosition().toString());
			}
			
			BasicDBObject doc = new BasicDBObject();
			doc.put("dia", String.valueOf(d));
			doc.put("clima", dayW.toString());
			doc.put("detalles", documentMap);
			collection.insert(doc);
			
		}
		
		//
		//RECORRER COLLECTION IMPRIMIENDO VALORES
		//
		
//		DBCursor cursorDocJSON = collection.find();
//		while (cursorDocJSON.hasNext()) {
//			System.out.println(cursorDocJSON.next());
//		}
		
		
	}

}
