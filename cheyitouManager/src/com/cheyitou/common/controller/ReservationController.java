package com.cheyitou.common.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.vo.ResFlag;
import com.cheyitou.common.model.vo.ReservationPagination;
import com.cheyitou.common.model.vo.ReservationVO;
import com.cheyitou.common.model.vo.ResultJson;
import com.cheyitou.common.service.ReservationService;


/**
 * 预约controller
 * @author Fox
 *
 */
@Controller
@RequestMapping("reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	/**
	 * 预约list显示
	 */
	@RequestMapping(value="/page")
	@ResponseBody
	public ResultJson<ReservationVO> toInfo(ReservationPagination pagination,ReservationVO reservationVO){
		pagination.setReservationVO(reservationVO);
		ResultJson<ReservationVO> json = reservationService.page(pagination);
		if(json == null){
			json = new ResultJson<ReservationVO>();
		}
		return json;
	}
	
	
	/**
	 * 操作
	 */
	@RequestMapping(value="/toOperat")
	@ResponseBody
	public ResFlag toOperat(Integer id,boolean flag,String status)throws BaseException{
		
		return new ResFlag(reservationService.toOperat(id,flag,status));
	}
}
