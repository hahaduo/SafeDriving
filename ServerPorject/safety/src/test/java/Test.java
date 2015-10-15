package test;

import java.math.BigDecimal;

import org.bson.Document;

import xyz.safety.base.MongoClientUtil;
import xyz.safety.vo.DevPos;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DevPos devpos = new DevPos();
		devpos.setDevId("dev_id_002");
		devpos.setLon(new BigDecimal("112.132"));
		devpos.setLat(new BigDecimal("112.132"));
		devpos.setSpd(new BigDecimal("113.142"));
//		
//		DevPos devpos1 = new DevPos();
//		devpos1.setDevId("dev_id_003");
//		devpos1.setLon(new BigDecimal("112.132"));
//		devpos1.setLat(new BigDecimal("112.132"));
//		devpos1.setSpd(new BigDecimal("113.142"));
//		
//		List<DevPos> list = new ArrayList<DevPos>();
//		list.add(devpos);
//		list.add(devpos1);
		Gson gson = new Gson();
		String json = gson.toJson(devpos,DevPos.class);
//		String json = gson.toJson(list, List.class);
//		System.out.println(json);
////		List<DevPos> list1 = gson.fromJson(json, new TypeToken<List<DevPos>>() {  
////        }.getType());
////		for(DevPos t : list1){
////			System.out.println("DEV_ID:"+t.getDevId()+" LON:"+t.getLon()+" LAT:"+t.getLat());
////		}
////		try {
////			Integer totalCount = (Integer) SqlMapClientUtil.getSqlMapClient().queryForObject("devPosDAO.getTotalDevPos");
//////			for(DevPos devpos : list){
//////				System.out.println("DEV_ID:"+devpos.getDevId()+" LON:"+devpos.getLon()+" LAT:"+devpos.getLat());
//////			}
////			System.out.println(totalCount.intValue());
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
		
		MongoDatabase database = MongoClientUtil.getDatabase("mydb");
//		
//		Document doc = new Document("name", "MongoDB")
//        .append("type", "database")
//        .append("count", 1)
//        .append("info", new Document("x", 203).append("y", 102));
//		
		
		FindIterable<Document> iterable = database.getCollection("DevPos").find();
		
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document.toJson());
		    }
		});
		
		
	}

}