package com.cheyitou.common.service;


import com.cheyitou.common.exception.BaseException;

public interface SmsService {
	public void sendSms(String mobiles, String content) throws BaseException;

	public void sendSms(String mobiles, String content, long task_id) throws BaseException;

	public void sendSms(String mobiles, String content, String sp_code) throws BaseException;
	
}
