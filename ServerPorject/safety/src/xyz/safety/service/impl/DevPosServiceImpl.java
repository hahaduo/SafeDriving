package xyz.safety.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;

import xyz.safety.base.BaseUtil;
import xyz.safety.base.SqlMapClientUtil;
import xyz.safety.dao.DevPosDAO;
import xyz.safety.service.IDevPosService;
import xyz.safety.vo.DevPos;


public class DevPosServiceImpl implements IDevPosService{
	
	private static Logger logger = Logger.getLogger(DevPosServiceImpl.class.getName());
	
	private static final String INSERT = "devPosDAO.insertDevPos";
	
	private static final String BATCH_INSERT = "devPosDAO.batchInsertDevPos";
	
	private static final String SELECT_TOTAL_CNT = "devPosDAO.getTotalDevPos";
	
	private static final String SELECT_DEV_POS_LIST = "devPosDAO.getDevPos";

	@Override
	public int saveDevPos(DevPos devpos) {
		// TODO Auto-generated method stub
		logger.info("insertDevPos start...");
		int returnVal = 0;
		try {
			SqlMapClientUtil.getSqlMapClient().insert(INSERT,devpos);
			returnVal = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("devPosDAO.insertDevPos Error.");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("insertDevPos end...");
		return returnVal;
	}

	@Override
	public int batchSaveDevPos(List<DevPos> devposlist) {
		// TODO Auto-generated method stub
		logger.info("batchInsertDevPos start...");
		int returnVal = 0;
		try {
			SqlMapClientUtil.getSqlMapClient().insert(BATCH_INSERT,devposlist);
			returnVal = devposlist.size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("devPosDAO.batchInsertDevPos Error.");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("batchInsertDevPos end...");
		return returnVal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DevPos> getDevPosList(DevPos devpos) {
		// TODO Auto-generated method stub
		logger.info("getDevPosList start...");
		List<DevPos> list = null;
		try {
			list = SqlMapClientUtil.getSqlMapClient().queryForList(SELECT_DEV_POS_LIST, devpos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("devPosDAO.getDevPosList Error.");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("getDevPosList end...");
		return list;
	}

	@Override
	public int getTotalCntOfDevPos(DevPos devpos) {
		// TODO Auto-generated method stub
		logger.info("getTotalCntOfDevPos start...");
		Integer totalCnt = 0;
		try {
			totalCnt = (Integer) SqlMapClientUtil.getSqlMapClient().queryForObject(SELECT_TOTAL_CNT, devpos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("devPosDAO.getTotalCntOfDevPos Error.");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("getTotalCntOfDevPos end...");
		
		return totalCnt.intValue();
	}

	@Override
	public int saveDevPos(String json) {
		// TODO Auto-generated method stub
		logger.info("saveDevPos Mongo start...");
		int returnVal = 0;
		DevPosDAO devPosDao = new DevPosDAO();
		try{
			devPosDao.insertDevPos(json);
			returnVal = 1;
		}catch(Exception e){
			logger.info("Exception on saveDevPos Mongo!");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		logger.info("saveDevPos Mongo end...");
		return returnVal;
	}

	@Override
	public int batchSaveDevPos(String json) {
		// TODO Auto-generated method stub
		logger.info("batchSaveDevPos Mongo start...");
		int returnVal = 0;
		DevPosDAO devPosDao = new DevPosDAO();
		try{
			returnVal = devPosDao.batchInsertDevPos(json);
		}catch(Exception e){
			logger.info("Exception on batchSaveDevPos Mongo!");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		logger.info("batchSaveDevPos Mongo end...");
		return returnVal;
		
	}

	@Override
	public List<Document> getDevPosListMongo(DevPos devpos) {
		// TODO Auto-generated method stub
		DevPosDAO devPosDao = new DevPosDAO();
		
		return devPosDao.getDevPos(devpos);
	}

	@Override
	public int getTotalCntOfDevPosMongo(DevPos devpos) {
		// TODO Auto-generated method stub
		DevPosDAO devPosDao = new DevPosDAO();
		return (int) devPosDao.getTotalDevPos(devpos);
	}

	
	@Override
	public long deleteByDate(String condition) {
		// TODO Auto-generated method stub
		logger.info("deleteByDate Mongo start...");
		long returnVal = 0;
		int[] cons = new int[5];
		if(condition!=null){
			for(int i=0;i<condition.length();i++){
				cons[i] = new Integer(String.valueOf(condition.charAt(i)));
			}
		}
		DevPosDAO devPosDao = new DevPosDAO();
		returnVal = devPosDao.deleteDevPosByDate(BaseUtil.getBeforeDate(cons));
		logger.info("deleteByDate Mongo end...");
		return returnVal;
	}

}
