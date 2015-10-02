package xyz.safety.base;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;

public class BaseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int perPageNum = 15;
	
	private int currentPageNum = 1;
	
	private int totalCount;
	
	private String objectId;

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	
	public int getStartNum(){
		int startNum = (this.currentPageNum-1)*this.perPageNum;
		return startNum;
	}
	
	public String getIdDate(){
		String returnValue = null;
		if(this.getObjectId()!=null){
			Date date = new ObjectId(this.getObjectId()).getDate();
			returnValue = BaseUtil.getFormatDate(date);
		}
		return returnValue;
	}

}
