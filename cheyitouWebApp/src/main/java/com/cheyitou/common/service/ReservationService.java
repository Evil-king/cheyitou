package com.cheyitou.common.service;

import java.util.Date;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Reservation;
import com.cheyitou.common.po.vo.ReservationVO;

public interface ReservationService {


	Reservation queryByUserId(Integer id);
	
	/**
	 * 提交预约
	 * @param time
	 * @param address
	 * @param type
	 */
	void toReservation(Date time, String address, String type,Integer userId)throws BaseException;
	
	/**
	 * 预约信息显示
	 * @throws BaseException
	 */
	ReservationVO toWait(Integer userId)throws BaseException;

}
