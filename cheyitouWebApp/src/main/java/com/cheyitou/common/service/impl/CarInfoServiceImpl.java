package com.cheyitou.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheyitou.common.dao.mapper.CarInfoMapper;
import com.cheyitou.common.dao.mapper.PersonMapper;
import com.cheyitou.common.dao.mapper.ReservationMapper;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.CarInfo;
import com.cheyitou.common.model.po.Person;
import com.cheyitou.common.model.po.Reservation;
import com.cheyitou.common.service.CarInfoService;
@Service
public class CarInfoServiceImpl implements CarInfoService {
	@Autowired
	private CarInfoMapper carInfoMapper;
	@Autowired
	private ReservationMapper reservationMapper;
	@Autowired
	private PersonMapper personMapper;


	/**
	 * 完善车辆信息
	 */
	@Transactional
	public void toCar(CarInfo carInfo) throws BaseException{
		CarInfo ci = carInfoMapper.queryByUserId(carInfo.getUserId());
		Reservation res = new Reservation();
		if(ci==null){
			res.setUserId(carInfo.getUserId());
			res.setIsReservation("1");;  //开启预约
			res.setStatus("0");//预约状态  0|可以预约
			res.setExpired("0");//未过期
			res.setIsToRes("0");//默认是0是未前往
			reservationMapper.create(res);
			res=reservationMapper.queryByUserId(carInfo.getUserId());
			Person person = new Person();//将预约id存入person表中
			person.setResId(res.getId());
			person.setUserId(carInfo.getUserId());
			personMapper.update(person);
			
			carInfo.setResId(res.getId());//将预约id存入carInfo表中
			
			int num = carInfoMapper.create(carInfo);
			if(num < 0){
				throw new BaseException("500001","创建数据失败!");
			}
		}else{
			int num = carInfoMapper.update(carInfo);
			if(num < 0){
				throw new BaseException("500002","更新数据失败!");
			}
		}
		
	}


	/**
	 * 根据userId查询车辆信息
	 */
	public CarInfo queryByUserId(Integer userId) {
		
		return carInfoMapper.queryByUserId(userId);
	}

}
