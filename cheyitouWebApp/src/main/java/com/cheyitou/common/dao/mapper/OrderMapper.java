package com.cheyitou.common.dao.mapper;


import org.apache.ibatis.annotations.Param;

import com.cheyitou.common.model.po.Order;
public interface OrderMapper {

	Order queryByNum(@Param("orderNum") String orderNum);
	
	Order queryByUserId(Integer userId);

	int update(Order order);
	
	int create(Order or);

	int updateToOrderNum(Order order);

	int count(Integer userId);
}