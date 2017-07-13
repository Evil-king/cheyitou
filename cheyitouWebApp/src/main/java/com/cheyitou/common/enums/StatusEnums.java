package com.cheyitou.common.enums;

public enum StatusEnums {
	
	/**
	 * 订单状态码
	 */
	ORDER_INGM(0,"订单进行中"),
	ORDER_FINISH(1,"订单已完成"),
	ORDER_RELEASE(2,"解除订单"),
	ORDER_REVIEW(3,"订单审核"),
	ORDER_FALI(4,"订单失败"),
	ORDER_SUCCESS(5,"订单成功"),
	
	/**
	 * 预约状态码
	 */
	RESERVATION_NULL(0,"可以预约"),
	REVIEW_ING(1,"审核中"),
	REVIEW_SUCCESS(2,"审核成功"),
	REVIEW_FAIL(3,"审核失败"),
	
	/**
	 * 提现状态码
	 */
	WITHDRAW_NULL(0,"未提现"),
	WITHDRAW_IMG(1," 提现中"),
	WITHDRAW_SUCCESS(2,"提现成功"),
	WITHDRAW_FAIL(3,"提现失败"),
	;
	
	private int code;
	private String msg;
	
	
	private StatusEnums(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
