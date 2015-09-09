package xyz.safety.service;

import java.util.List;

import org.bson.Document;


import xyz.safety.vo.DevPos;

public interface IDevPosService {
	
	public int saveDevPos(DevPos devpos);
	
	public int batchSaveDevPos(List<DevPos> devposlist);
	
	public List<DevPos> getDevPosList(DevPos devpos);
	
	public int getTotalCntOfDevPos(DevPos devpos);
	
	public int saveDevPos(String json);
	
	public int batchSaveDevPos(String json);
	
	public List<Document> getDevPosListMongo(DevPos devpos);
	
	public int getTotalCntOfDevPosMongo(DevPos devpos);
	
	public long deleteByDate(String condition);
	
	public int sycData2MySQL();
}
