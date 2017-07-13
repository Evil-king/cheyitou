package com.cheyitou.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheyitou.common.dao.mapper.MyAccountMapper;
import com.cheyitou.common.dao.mapper.OrderMapper;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.MyAccount;
import com.cheyitou.common.service.MyAccountService;
import com.cheyitou.common.util.DateUtil;

@Service
public class MyAccountServiceImpl implements MyAccountService {
	@Autowired
	private MyAccountMapper myAccountMapper;
	@Autowired
	private OrderMapper orderMapper;
	

	/**
	 * 我的账号数据
	 */
	public Map<String,Object> toData(Integer userId) throws BaseException{
		Map<String,Object> map = new HashMap<String,Object>();
		MyAccount  my = myAccountMapper.queryByUserId(userId);
		if(my.getAccountAmount()==null ){
			map.put("accountAmount", 0);
		}else{
			map.put("accountAmount", my.getAccountAmount());
		}
		if(my.getGetAmount()==null){
			map.put("getAmount", 0);
		}else{
			map.put("getAmount", my.getGetAmount());
		}
		map.put("orderNum", orderMapper.count(userId));//统计已完成订单数
		return map;
	}

	/**
	 * 账号明细
	 */
	public List<Map<String,Object>> toDetail(Integer userId) throws BaseException{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		MyAccount my = myAccountMapper.queryByUserId(userId);
		map.put("time",DateUtil.format(my.getGetTime(),"yyyy-MM-dd"));//提现时间
		map.put("orderNum",my.getOrderNum());//订单号
		map.put("fundingSource", my.getFundingSource());//资金来源
		list.add(map);
		return list;
	}


}
