package com.cheyitou.common.dao;

import java.util.List;

import com.cheyitou.common.model.po.Order;
import com.cheyitou.common.model.vo.OrderPagination;
import com.cheyitou.common.model.vo.OrderVO;
public interface OrderMapper {
	
	/**
	 * 统计
	 * @param orderVO
	 * @return
	 */
	int total(OrderVO orderVO);
	
	/**
	 * list显示数据
	 * @param orderPagination
	 * @return
	 */
	List<OrderVO> list(OrderPagination orderPagination);
	
	/**
	 * 创建新订单
	 * @param order
	 * @return
	 */
	int create(Order order);
	
	/**
	 * 更新
	 * @param order
	 * @return
	 */
	int update(Order order);
	
}