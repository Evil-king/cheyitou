package com.cheyitou.common.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.cheyitou.common.model.po.Person;
public interface PersonMapper {
   
	Person queryByUserId(@Param("userId") Integer userId);

	int create(Person per);

	int update(Person per);

}