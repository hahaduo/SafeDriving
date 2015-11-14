package xyz.safety.vo;

import java.math.BigDecimal;

import xyz.safety.base.BaseVO;

public class DevPos  extends BaseVO{


	private static final long serialVersionUID = 6504746629075909523L;

	private String devId;

	private String cn;

	private String addr;

	private String loc;

	private BigDecimal lon;

	private BigDecimal lat;

	private BigDecimal spd;

	private BigDecimal bear;

	private String dtm;

	private String regDate;

	private String goId;

	public String getGoId() {
		return goId;
	}

	public void setGoId(String goId) {
		this.goId = goId;
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getSpd() {
		return spd;
	}

	public void setSpd(BigDecimal spd) {
		this.spd = spd;
	}

	public String getDtm() {
		return dtm;
	}

	public void setDtm(String dtm) {
		this.dtm = dtm;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public BigDecimal getBear() {
		return bear;
	}

	public void setBear(BigDecimal bear) {
		this.bear = bear;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}



}