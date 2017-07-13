package com.cheyitou.common.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.cheyitou.common.model.po.Reservation;
public interface ReservationMapper {
    
	Reservation queryByUserId(Integer id);

	int create(Reservation rv);

	int update(Reservation res);

	Reservation queryToStatus(@Param("userId")Integer userId,@Param("resId")Integer resId);

	Reservation queryInfo(Integer userId);
	
}