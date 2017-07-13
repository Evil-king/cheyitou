package com.cheyitou.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.CarInfo;
import com.cheyitou.common.model.po.Person;
import com.cheyitou.common.po.vo.Result;
import com.cheyitou.common.service.CarInfoService;
import com.cheyitou.common.service.PersonService;

/**
 * 个人设置Controller
 * @author Fox
 *
 */
@Controller
@RequestMapping("person")
public class PersonConreoller extends BaseController{
	@Autowired
	private PersonService personService;
	@Autowired
	private CarInfoService carInfoService;
	
	
	/**
	 * 设置邮箱 支付宝账号 头像
	 */
	@RequestMapping(value="/settingThree",method=RequestMethod.POST)
	@ResponseBody
	public Result toThree(Person person) throws BaseException{
		personService.setting(person);
		return new Result("1","设置成功");
	}
	
	/**
	 * 完善个人信息
	 */
	@RequestMapping(value="/person_setting",method=RequestMethod.POST)
	@ResponseBody
	public Result toPerson(Person person) throws BaseException{
		personService.toPerson(person);
		return new Result("1","提交成功");
	}
	
	
	/**
	 * 完善车辆信息
	 */
	@RequestMapping(value ="/carInfo",method=RequestMethod.POST)
	@ResponseBody
	public Result toCar(CarInfo carInfo) throws BaseException{
		carInfoService.toCar(carInfo);
		return new Result("1","提交成功");
	}
}
