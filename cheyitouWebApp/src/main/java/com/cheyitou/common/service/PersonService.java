package com.cheyitou.common.service;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Person;

public interface PersonService {
	
	/**
	 * 设置邮箱 支付宝账号 头像
	 * @param mail
	 * @param image
	 * @param payAccount
	 */
	void setting(Person person)throws BaseException;
	
	/**
	 * 完善个人信息
	 * @param person
	 */
	void toPerson(Person person)throws BaseException;
	
	/**
	 * 更userId查询信息
	 * @param userId
	 * @return
	 */
	Person queryByUserId(Integer userId);
	
	/**
	 * 更新头像
	 * @param person
	 * @return
	 */
	int update(Person person);


}
