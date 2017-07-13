package com.cheyitou.common.model.po;

import java.util.Date;

public class Person {

	private Integer id;
	private String name;//名字
	private String sex;//性别 0|男  1|女
	private String mobilePhone;//联系电话
	private String mail;//邮箱
	private String payAccount;//支付账号
	private String idCard;//身份证
	private String drverCard;//驾驶证
	private String address;//地址
	private Date getCreate;//创建时间
	private Date getModified;//修改时间
	private String image;//头像
	private Integer userId;
	private Integer resId;//预约id
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getDrverCard() {
		return drverCard;
	}
	public void setDrverCard(String drverCard) {
		this.drverCard = drverCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getResId() {
		return resId;
	}
	public void setResId(Integer resId) {
		this.resId = resId;
	}
	
}