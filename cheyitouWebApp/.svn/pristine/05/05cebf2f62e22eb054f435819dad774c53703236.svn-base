package com.cheyitou.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Order;
import com.cheyitou.common.po.vo.Result;
import com.cheyitou.common.service.OrderService;
/**
 * 订单
 * @author Fox
 *
 */
@Controller
@RequestMapping("order")
public class OrderController extends BaseController{
	@Autowired
	private OrderService orderService;
	
	/**
	 * 解除订单
	 */
	@RequestMapping(value="/cancle_order",method=RequestMethod.POST)
	@ResponseBody
	public Result toOrder(String orderNum,Integer userId) throws BaseException{
		Order or = orderService.toOrder(orderNum,userId);
		return new Result("1","解除成功",or.getOrderNum());
	}
	
}
