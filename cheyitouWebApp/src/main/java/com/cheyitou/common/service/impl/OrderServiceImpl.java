package com.cheyitou.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheyitou.common.dao.mapper.OrderMapper;
import com.cheyitou.common.dao.mapper.ReservationMapper;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Order;
import com.cheyitou.common.model.po.Reservation;
import com.cheyitou.common.service.OrderService;
import com.cheyitou.common.util.StringUtil;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ReservationMapper reservationMapper;


	/**
	 * 解除订单
	 */
	public Order toOrder(String orderNum,Integer userId) throws BaseException{
		Order order = orderMapper.queryByNum(orderNum);
		if(order.getOrderNum()==null || order.getOrderNum() ==""){
		     throw new BaseException("200002","订单号不存在!");
		  } 
		Order or = new Order();
		or.setOrderNum(orderNum);
		or.setUserId(userId);
		or.setStatus("2");//解除订单
		Reservation res = new Reservation();
		res.setUserId(userId);
		res.setStatus("0");//解除订单之后预约状态改为0 可以预约
		res.setExpired("0");
		reservationMapper.update(res);
		int num =  orderMapper.updateToOrderNum(or);
		if(num < 0){
			throw new BaseException("200008","更新订单状态失败");
		}
		return or;
	}

	/**
	 * 提交订单
	 */
	public Order toFinish(String front_image, String back_image, String side_image,Integer userId) throws BaseException{
		if(StringUtil.isEmpty(front_image)){
			throw new BaseException("200004","资质正面不能为空");
		}
		if(StringUtil.isEmpty(back_image)){
			throw new BaseException("200005","资质背面不能为空");
		}
		if(StringUtil.isEmpty(back_image)){
			throw new BaseException("200006","资质侧面不能为空");
		}
		Order order = new Order();
		order.setFrontImg(front_image);
		order.setBackImg(back_image);
		order.setSideImg(side_image);
		order.setUserId(userId);
		order.setStatus("3");//订单进行中
		int num = orderMapper.update(order);
		if(num < 0 ){
			throw new BaseException("200007","订单更新数据失败");
		}
		return order;
	}



}
