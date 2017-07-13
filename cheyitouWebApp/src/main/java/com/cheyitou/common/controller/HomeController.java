package com.cheyitou.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.CarInfo;
import com.cheyitou.common.model.po.Person;
import com.cheyitou.common.po.vo.DataInfoVO;
import com.cheyitou.common.po.vo.Result;
import com.cheyitou.common.service.CarInfoService;
import com.cheyitou.common.service.IndexService;
import com.cheyitou.common.service.PersonService;

/**
 * 主页
 * @author Fox
 *
 */
@Controller
@RequestMapping("/")
public class HomeController extends BaseController{
	@Autowired
	private IndexService indexService;
	@Autowired
	private PersonService personService;
	@Autowired
	private CarInfoService carInfoService;
	
	@RequestMapping(value="index",method=RequestMethod.POST)
	@ResponseBody
	public Result toIndex(Integer userId) throws BaseException{
		DataInfoVO dataInfoVO = new DataInfoVO();
		Person p = personService.queryByUserId(userId);
		CarInfo car = carInfoService.queryByUserId(userId);
		if(p==null || car==null){
			throw new BaseException("300008", "请尽快完善个人信息");
		}
		dataInfoVO.setMail(p.getMail());
		dataInfoVO.setImage(p.getImage());
		dataInfoVO.setName(p.getName());
		dataInfoVO.setPayAccount(p.getPayAccount());
		dataInfoVO.setAddress(p.getAddress());
		dataInfoVO.setSex(p.getSex());
		dataInfoVO.setPhone(p.getMobilePhone());
		dataInfoVO.setIdCard(p.getIdCard());
		dataInfoVO.setDrverCard(p.getDrverCard());
		dataInfoVO.setCertificate(car.getCertificate());
		dataInfoVO.setDrivingLicense(car.getDrivingLicense());
		dataInfoVO.setPlateNumber(car.getPlateNumber());
		dataInfoVO.setCarType(car.getCarType());
		dataInfoVO.setVehicleBrand(car.getVehicleBrand());
		return new Result("1","",indexService.toIndex(userId),dataInfoVO);
		
	}
	
}
