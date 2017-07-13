package com.cheyitou.common.service;


import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.po.vo.IndexVO;

public interface IndexService {
	/**
	 * 首页数据
	 * @return
	 */
	IndexVO toIndex(Integer userId) throws BaseException;

}
