package com.cheyitou.common.model.po;

import java.util.Date;

public class Reservation {

	private Integer id;
	private Date goTime;//前往时间
	private Date orderTime;//预约时间
	private String address;//预约地址
	private String carType;//预约车型
	private String carAdvert;//车贴广告位置
	private Integer userId;
	private String status;//状态  1|审核  2|提交成功
	private String isReservation; // 是否开启预约 0|关闭 1|开启
	private Date getCreate;//创建时间
    private Date getModified;//修改时间
    private String expired;//预约过期 0|未过期 1|过期
    private String isToRes;//是否前往
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getGoTime() {
		return goTime;
	}
	public void setGoTime(Date goTime) {
		this.goTime = goTime;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTtime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarAdvert() {
		return carAdvert;
	}
	public void setCarAdvert(String carAdvert) {
		this.carAdvert = carAdvert;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsReservation() {
		return isReservation;
	}
	public void setIsReservation(String isReservation) {
		this.isReservation = isReservation;
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
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getIsToRes() {
		return isToRes;
	}
	public void setIsToRes(String isToRes) {
		this.isToRes = isToRes;
	}
}