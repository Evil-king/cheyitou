package com.cheyitou.common.model.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cheyitou.common.model.po.Reservation;

public class ReservationVO extends Reservation{
	private String orderNum;//订单号
	private String mobilePhone;//账号
	private String drivingLicense;//行驶证
	private String drverCard;//驾驶证
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;//开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;//结束时间
	
	
	public ReservationVO() {
		super();
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public String getDrverCard() {
		return drverCard;
	}
	public void setDrverCard(String drverCard) {
		this.drverCard = drverCard;
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
