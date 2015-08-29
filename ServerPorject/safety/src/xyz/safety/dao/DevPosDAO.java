package xyz.safety.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import xyz.safety.base.BaseMongoDAO;
import xyz.safety.base.BaseUtil;
import xyz.safety.vo.DevPos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

public class DevPosDAO extends BaseMongoDAO{
	
	
	public long getTotalDevPos(DevPos devpos){
		return  this.getDatabase().getCollection("DevPos").count();
	}
	
	public List<Document> getDevPos(DevPos devpos){
		final List<Document> list = new ArrayList<Document>();
		FindIterable<Document> items = null;
		items = this.getDatabase().getCollection("DevPos")
				.find()
				.sort(new Document("_id",-1)).skip(devpos.getStartNum()).limit(15);
			
		
		items.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		    		list.add(document.append("idDate", BaseUtil.getFormatDate(document.getObjectId("_id").getDate())));
		    }
		});
		return  list;
	}
	
	public void insertDevPos(String json){
		new Document();
		Document parse = Document.parse(json);
		this.getDatabase().getCollection("DevPos").insertOne(parse);
	}
	
	public int batchInsertDevPos(String json){
		Gson gson = new Gson();
		List<Document> devposlist = gson.fromJson(json, new TypeToken<List<Document>>() {  
	        }.getType());
		this.getDatabase().getCollection("DevPos").insertMany(devposlist);
		return devposlist.size();
	}
	
}
