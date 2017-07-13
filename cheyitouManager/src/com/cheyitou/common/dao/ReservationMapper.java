package com.cheyitou.common.dao;

import java.util.List;

import com.cheyitou.common.model.po.Reservation;
import com.cheyitou.common.model.vo.ReservationPagination;
import com.cheyitou.common.model.vo.ReservationVO;
public interface ReservationMapper {
	
	int update(Reservation res);
    
	List<ReservationVO> list(ReservationPagination pagination);

	int total(Reservation reservationVO);

}