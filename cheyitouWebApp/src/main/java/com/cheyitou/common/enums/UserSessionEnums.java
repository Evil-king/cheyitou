/**
 * Copyright 2015-2016 eyaomall.cn
 * All rights reserved.
 *
 * @project
 * @author pro
 * @version 1.0
 * @date 2016-03-07
 */
package com.cheyitou.common.enums;

public enum UserSessionEnums {

	_MALL_FORM("user"), 
	_MALL_FORM_ID("memberId"),
	_MALL_FORM_PHONE("phone"),
	_MALL_FORM_LAST_TIME("lastTime"),
	_MALL_FORM_PASSWD("passwd"),
	_MALL_FORM_CODE("code");
	
	private String name;
	
	UserSessionEnums(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
