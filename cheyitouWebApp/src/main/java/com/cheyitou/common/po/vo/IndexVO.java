package com.cheyitou.common.po.vo;
public class IndexVO {
	private String img;//头像
	private String name;//用户名
	private int days;//到期天数
	private String orderNum;//订单号
	private String str;//描述文字
	private String reviewImage;//审核图片
	private String code;//状态码
	private String msg;//状态信息
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getReviewImage() {
		return reviewImage;
	}
	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}
	
}
