package com.cheyitou.common.dao.mapper;

import com.cheyitou.common.model.po.CarInfo;

public interface CarInfoMapper {

	CarInfo query(CarInfo car);

	int create(CarInfo carInfo);

	int update(CarInfo carInfo);

	CarInfo queryByUserId(Integer userId);

}