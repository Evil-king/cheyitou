package com.cheyitou.common.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheyitou.common.dao.mapper.PersonMapper;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Person;
import com.cheyitou.common.service.PersonService;
import com.cheyitou.common.util.StringUtil;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonMapper personMapper;
	
	/**
	 * 设置邮箱 支付宝账号 头像
	 * mail
	 * userId
	 * payAccount
	 */
	public void setting(Person person) throws BaseException{
		if(StringUtil.isEmpty(person.getMail())){
			throw new BaseException("300001","邮箱不能为空");
		}
		if(!StringUtil.isEmail(person.getMail())){
			throw new BaseException("300007","邮箱格式不正确");
		}
		if(StringUtil.isEmpty(person.getPayAccount())){
			throw new BaseException("300003","支付账户不能为空");
		}
	Person pp = personMapper.queryByUserId(person.getUserId());
		Person per = new Person();
		per.setMail(person.getMail());
		per.setPayAccount(person.getPayAccount());
		per.setUserId(person.getUserId());
		int num ;
		if(pp == null){
			num = personMapper.create(per);
			if(num < 0){
				throw new BaseException("300004","创建数据失败!");
			}
		}else{
			num = personMapper.update(per);
			if(num < 0){
				throw new BaseException("300005","更新数据失败!");
			}
		}
		
	}

	/**
	 * 完善个人信息
	 */
	public void toPerson(Person person) throws BaseException{
		Person pp = personMapper.queryByUserId(person.getUserId());
		if(pp==null){
			int num = personMapper.create(person);
			if(num < 0){
				throw new BaseException("300006","创建数据失败!");
			}
		}else{
			int num = personMapper.update(person);
			if(num < 0){
				throw new BaseException("300005","更新数据失败!");
			}
		}
		
	}
	

	/**
	 * 根据userId查询信息
	 */
	public Person queryByUserId(Integer userId) {
		
		return personMapper.queryByUserId(userId);
	}

	/**
	 * 更新头像
	 */
	public int update(Person person) {
		
		return personMapper.update(person);
	}

}
