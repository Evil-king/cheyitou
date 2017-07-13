package com.cheyitou.common.enums;


public enum ErrorCode {
	
	/**
	 * 系统
	 */
	SYSTEM_BUSINESS(-1,"系统繁忙"),
	REQUEST_SUCCESS(0,"请求成功"),
	
	/**
	 * 用户 100001开头
	 */
	PHONE_OR_PWSSWD_ISNULL(100001,"手机号或者密码为空"),
	DUANXIN_CODE(100002,"短信验证码不能为空!"),
	USER_ISNULL(100003,"用户不存在!"),
	OLD_PASSWD(100004,"旧密码不存在,请重试!"),
	ACCOUNT_ISNOT_NULL(100005,"账号不能为空"),
	PHONE_ISNOTNULL_OR(100006,"手机号码不能为空或者格式不正确！"),
	PHONE_IS_REGISTER(100007,"手机号码已经被注册，请更换后重试！"),
	INCORRECT_PHONEFORMT(100008,"手机格式不正确"),
	VERIFICATION_CODE_NO_MATCH(100009,"验证码不匹配"),
	ACCOUNT_IS_EXIST(100010,"账号已注册！"),
	INGORE_PHONE(100011,"非法手机号"),
	ADD_USER_FALSE(100012,"新增用户失败"),
	NEWPASSWD_UPDATE_FALSE(100013,"更新密码失败！"),
	NO_DATA(000000,"没有数据!"),

	/**
	 * 订单 200001开头
	 */
	ON_ORDER(200001,"没有订单！"),
	ACCOUNT_ISUNLL(200002,"账户不存在！"),
	OREDE_NUM_NULL(200003,"订单号不存在!"),
	IMG_FRONT(200004,"正面图片不能为空"),
	IMG_BACK(200005,"背面图片不能为空"),
	IMG_SIDE(200006,"侧面面图片不能为空"),
	
	/**
	 * 个人信息 300001开头
	 */
	
	/**
	 * 预约 400001开头
	 */
	
	/**
	 *车辆信息 500001开头
	 */
	
	/**
	 * 提现 110001开头
	 */
	;
	
	
	private int code;
	private String msg;
	
	private ErrorCode(int code,String msg){
		this.setCode(code);
		this.setMsg(msg);
	}


	public void setCode(int code) {
		this.code = code;
	}
	

	public int getCode() {
		return code;
	}


	public String getMsg() {
		return msg;
	}

	private void setMsg(String msg) {
		this.msg = msg;
	}

	
}
