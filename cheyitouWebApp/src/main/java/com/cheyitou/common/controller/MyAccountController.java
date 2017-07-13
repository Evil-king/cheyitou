package com.cheyitou.common.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.po.vo.Result;
import com.cheyitou.common.service.MyAccountService;

/**
 * 我的账户
 * @author Fox
 *
 */
@Controller
@RequestMapping("myAccount")
public class MyAccountController extends BaseController{
	@Autowired
	private MyAccountService myaccountService;
	/**
	 * 我的账号数据
	 * @return
	 */
	@RequestMapping(value="/data",method=RequestMethod.POST)
	@ResponseBody
	public  Result toData(Integer userId) throws BaseException{
		
		return new Result("1","",myaccountService.toData(userId));
	}
	
	/**
	 * 账号明细
	 */
	@RequestMapping(value = "/detail",method=RequestMethod.POST)
	@ResponseBody
	public Result toDetail(Integer userId) throws BaseException{

		return new Result("1","",myaccountService.toDetail(userId));
	}
}
