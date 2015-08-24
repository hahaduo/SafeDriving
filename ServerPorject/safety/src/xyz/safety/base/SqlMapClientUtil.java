package xyz.safety.base;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientUtil {
	
	
	private static SqlMapClient sqlMapClient = null;
	
	
	public static SqlMapClient getSqlMapClient(){
		if(sqlMapClient == null){
			initSqlMapClient();
		}
		return sqlMapClient;
	}
	
	private static void initSqlMapClient(){
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(PSP.SQL_MAP_CONFIG_PATH);
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
	
//	public List queryForList(SqlParameter sqlParameter){
//		List returnList = null;
//		try {
//			returnList = this.sqlMapClient.queryForList(sqlParameter.getStatementId(), sqlParameter.getParameterObj());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return returnList;
//	}
//	
//	public Object queryForObj(SqlParameter sqlParameter) throws SQLException {
//		return this.sqlMapClient.queryForObject(sqlParameter.getStatementId(), sqlParameter.getParameterObj());
//	}
//	
//	public Object insert(SqlParameter sqlParameter) throws SQLException{
//		Object returnObj = null;
//		this.sqlMapClient.startTransaction();
//		returnObj = this.sqlMapClient.insert(sqlParameter.getStatementId(), sqlParameter.getParameterObj());
//		this.sqlMapClient.endTransaction();
//		return returnObj;
//	}
//	
//	public int update(SqlParameter sqlParameter) throws SQLException{
//		int returnVal = 0;
//		this.sqlMapClient.startTransaction();
//		returnVal = this.sqlMapClient.update(sqlParameter.getStatementId(), sqlParameter.getParameterObj());
//		this.sqlMapClient.endTransaction();
//		return returnVal;
//	}
//	
//	public int delete(SqlParameter sqlParameter) throws SQLException{
//		int returnVal = 0;
//		this.sqlMapClient.startTransaction();
//		returnVal = this.sqlMapClient.delete(sqlParameter.getStatementId(), sqlParameter.getParameterObj());
//		this.sqlMapClient.endTransaction();
//		return returnVal;
//	}
//	
//	public void transactionExec(List<SqlParameter> sqlParameters) throws SQLException{
//		this.sqlMapClient.startTransaction();
//		for(SqlParameter sqlParameter:sqlParameters){
//			if(PSP.OP_INSERT.equals(getOptype(sqlParameter))){
//				this.sqlMapClient.insert(sqlParameter.getStatementId(), sqlParameter.getParameterObj());
//			}else if(PSP.OP_UPDATE.equals(getOptype(sqlParameter))){
//				this.sqlMapClient.update(sqlParameter.getStatementId(), sqlParameter.getParameterObj());
//			}else if(PSP.OP_DELETE.equals(getOptype(sqlParameter))){
//				this.sqlMapClient.delete(sqlParameter.getStatementId(), sqlParameter.getParameterObj());
//			}else{
//				throw new SQLException("Please Check the SqlParameter.operationType !");
//			}
//		}
//		this.sqlMapClient.endTransaction();
//	}
//	
//	private String getOptype(SqlParameter sqlParameter){
//		String returnStr = "";
//		if(sqlParameter.getOperationType()==null){
//			String statementId = sqlParameter.getStatementId();
//			if(statementId.startsWith(PSP.OP_INSERT)){
//				returnStr = PSP.OP_INSERT;
//			}else if(statementId.startsWith(PSP.OP_UPDATE)){
//				returnStr = PSP.OP_UPDATE;
//			}else if(statementId.startsWith(PSP.OP_DELETE)){
//				returnStr = PSP.OP_DELETE;
//			}
//				
//		}else{
//			returnStr = sqlParameter.getOperationType();
//		}
//		return returnStr;
//	}
//	
}
