package com.cheyitou.common.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.po.vo.Result;
import com.cheyitou.common.service.DepositService;

/**
 * 提现Controller
 * @author Fox
 *
 */
@Controller
@RequestMapping("deposit")
public class DepositController extends BaseController{
	@Autowired
	private DepositService depositService;
	
	/**
	 * 提现
	 * @param money
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/data",method=RequestMethod.POST)
	@ResponseBody
	public Result toData(BigDecimal money,String account,Integer userId)throws BaseException{
		depositService.toData(money,account,userId);
		return new Result("1","提现成功");
	}
	
	/**
	 * 提现记录
	 */
	@RequestMapping(value = "/record",method=RequestMethod.POST)
	@ResponseBody
	public Result toRecord(Integer userId) throws BaseException{
		
		return new Result("1","",depositService.toRecord(userId));
	}
}
