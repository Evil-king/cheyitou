package com.cheyitou.common.dao.mapper;


import com.cheyitou.common.model.po.Deposit;

public interface DepositMapper {

	int updateById(Deposit dp);

	Deposit queryByUserId(Deposit des);
	
	int create(Deposit dp);
}