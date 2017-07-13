package com.cheyitou.common.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.User;

public interface UserService {
	
	/**
	 * 查询是否登录
	 * @param response 
	 * @param request 
	 * @param us
	 * @return
	 */
	User login(String phone, String passwd)throws BaseException;
	
	/**
	 * 注册
	 * @param phone
	 * @param passwd
	 * @param code
	 * @param request 
	 * @param response 
	 * @param request
	 * @param response
	 * @return
	 */
	User register(String phone, String passwd, String code)throws BaseException;
	
	/**
	 * 忘记密码
	 * @param phone
	 * @param code
	 * @param request
	 * @param response
	 * @return
	 */
	void forget(String phone, String code, HttpServletRequest request, HttpServletResponse response)throws BaseException;
	
	/**
	 * 修改密码
	 * @param phone
	 * @param passwd
	 * @param oldPasswd
	 */
	void savePasswd(String phone, String newPasswd, String oldPasswd)throws BaseException;
	
	/**
	 * 生成新密码
	 * @param phone
	 * @param request
	 * @param response
	 */
	void newPasswd(String phone,HttpServletRequest request)throws BaseException;


}
