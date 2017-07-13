package com.cheyitou.common.model.po;

import java.util.Date;

public class Advert {

	private Integer id;
	private String t_type;//投放类型
	private String advert_type;//广告类型
	private String car_type;//投放车型
	private Date getCreate;//创建时间
    private Date getModified;//修改时间
    
	public Integer getID() {
		return id;
	}

	public void setID(Integer ID) {
		this.id = ID;
	}

	public String getT_TYPE() {
		return t_type;
	}

	public void setT_TYPE(String t_TYPE) {
		this.t_type = t_TYPE;
	}

	public String getADVERT_TYPE() {
		return advert_type;
	}

	public void setADVERT_TYPE(String ADVERT_TYPE) {
		this.advert_type = ADVERT_TYPE;
	}

	public String getCAR_TYPE() {
		return car_type;
	}

	public void setCAR_TYPE(String CAR_TYPE) {
		this.car_type = CAR_TYPE;
	}

	public Date getGetCreate() {
		return getCreate;
	}

	public void setGetCreate(Date getCreate) {
		this.getCreate = getCreate;
	}

	public Date getGetModified() {
		return getModified;
	}

	public void setGetModified(Date getModified) {
		this.getModified = getModified;
	}
	
}