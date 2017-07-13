package com.cheyitou.common.model.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cheyitou.common.model.po.Order;

public class OrderVO extends Order{
	private String mobilePhone;//账号
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;//开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;//结束时间
	
	

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
