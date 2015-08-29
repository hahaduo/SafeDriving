package xyz.safety.base;

import com.mongodb.client.MongoDatabase;

public class BaseMongoDAO {
	
	private MongoDatabase database;
	
	public MongoDatabase getDatabase() {
		return database;
	}

	public BaseMongoDAO(){
		database = MongoClientUtil.getDatabase();
	}
	
	public BaseMongoDAO(String dbname){
		database = MongoClientUtil.getDatabase(dbname);
	}
}
