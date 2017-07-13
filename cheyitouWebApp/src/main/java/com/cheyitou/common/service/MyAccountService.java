package com.cheyitou.common.service;

import java.util.List;
import java.util.Map;

import com.cheyitou.common.exception.BaseException;

public interface MyAccountService {

	/**
	 * 我的账号数据
	 * @return
	 */
	Map<String,Object> toData(Integer userId) throws BaseException;
	
	/**
	 * 账号明细
	 * @return
	 */
	List<Map<String,Object>> toDetail(Integer userId) throws BaseException;

}
