package com.cheyitou.common.service;


import java.util.List;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.vo.ReservationPagination;
import com.cheyitou.common.model.vo.ReservationVO;
import com.cheyitou.common.model.vo.ResultJson;

public interface ReservationService {
	
	/**
	 * 操作
	 * @return
	 */
	boolean toOperat(Integer id,boolean flag,String status)throws BaseException;
	
	/**
	 * page查询
	 */
	ResultJson<ReservationVO> page(ReservationPagination pagination);
	
	/**
	 * 预约信息list
	 * @return
	 */
	List<ReservationVO> list(ReservationVO reservationVO);
	
	/**
	 * 统计
	 * @param reservationVO
	 * @return
	 */
	int total(ReservationVO reservationVO);

}
