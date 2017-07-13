package com.cheyitou.common.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.po.vo.Result;
import com.cheyitou.common.service.ReservationService;


/**
 * 预约Controller
 * @author Fox
 *
 */
@Controller
@RequestMapping("reservation")
public class ReservationController extends BaseController{
	@Autowired
	private ReservationService reservationService;
	/**
	 * 提交预约
	 */
	@RequestMapping(value="/to_reservation",method=RequestMethod.POST)
	@ResponseBody
	public Result toReservation(Date time,String address,String type,Integer userId)throws BaseException{
		reservationService.toReservation(time,address,type,userId);
		return new Result("1","提交预约成功");
	}
	
	/**
	 * 预约信息显示
	 */
	@RequestMapping(value="/waitting",method=RequestMethod.POST)
	@ResponseBody
	public  Result toWait(Integer userId) throws BaseException{
		
		return new Result("1","",reservationService.toWait(userId));
	}
}
