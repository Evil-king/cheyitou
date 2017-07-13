package com.cheyitou.common.service;

import java.math.BigDecimal;
import java.util.List;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.po.vo.DepositVO;

public interface DepositService {

	/**
	 * 提现记录
	 * @return
	 */
	List<DepositVO> toRecord(Integer userId) throws BaseException;
	
	/**
	 * 体现数据
	 */
	void toData(BigDecimal money,String account,Integer userId) throws BaseException;

}
