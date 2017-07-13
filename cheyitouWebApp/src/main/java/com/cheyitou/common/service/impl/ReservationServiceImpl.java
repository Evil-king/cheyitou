package com.cheyitou.common.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheyitou.common.dao.mapper.ReservationMapper;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Reservation;
import com.cheyitou.common.po.vo.ReservationVO;
import com.cheyitou.common.service.ReservationService;
import com.cheyitou.common.util.DateUtil;
/**
 * 预约实现类
 * @author Fox
 *
 */
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationMapper reservationMapper;

	public Reservation queryByUserId(Integer id) {
		return reservationMapper.queryByUserId(id);
	}

	/**
	 * 提交预约
	 */
	public void toReservation(Date time, String address, String type,Integer userId) throws BaseException{
		Reservation rv = new Reservation();
		rv.setGoTime(time);
		rv.setAddress(address);
		rv.setCarAdvert(type);//广告类型 车内 车外
		rv.setUserId(userId);
		rv.setStatus("1");//预约状态为 1|审核中
		int num = reservationMapper.update(rv);
		if(num < 0){
			throw new BaseException("400001","提交预约信息失败!");
		}
	}

	/**
	 * 预约信息显示
	 */
	public ReservationVO toWait(Integer userId) throws BaseException {
		ReservationVO reservationVO = new ReservationVO();
		Reservation res = reservationMapper.queryInfo(userId);
		if(res == null){
			reservationVO.setCode("400002");
			reservationVO.setMsg("无预约信息");
			return reservationVO;
		}
		if(res.getStatus().equals("4")){
			reservationVO.setAddress(res.getAddress());//地点
			reservationVO.setCarAdvert(res.getCarAdvert());;//车贴广告位置
			reservationVO.setTime(DateUtil.format(res.getOrderTime()));//预约时间
			reservationVO.setCode("1");
			return reservationVO;
		}
		reservationVO.setAddress(res.getAddress());//地点
		reservationVO.setCarAdvert(res.getCarAdvert());;//车贴广告位置
		reservationVO.setTime(DateUtil.format(res.getOrderTime()));//预约时间
		reservationVO.setCode("1");
		return reservationVO;
	}

}
