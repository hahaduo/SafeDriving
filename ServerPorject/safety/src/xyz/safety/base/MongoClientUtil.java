package xyz.safety.base;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoClientUtil {
	
	private static final String IP = "mongodb.ip";
	
	private static final String PORT = "mongodb.port";
	
	private static final String DB_NM = "mongodb.dbname";
	
	private static MongoClient mongoClient = null;
	
	private static void initMongoClient(){
		mongoClient = new MongoClient( SysConfig.getProperty(IP) , Integer.parseInt(SysConfig.getProperty(PORT)) );
	}
	
	public static MongoClient getMongoClient(){
		if(mongoClient == null){
			initMongoClient();
		}
		return mongoClient;
	}
	
	public static MongoDatabase getDatabase(String dbname){
		return getMongoClient().getDatabase(dbname);
	}
	
	public static MongoDatabase getDatabase(){
		return getMongoClient().getDatabase(SysConfig.getProperty(DB_NM));
	}
		
}
