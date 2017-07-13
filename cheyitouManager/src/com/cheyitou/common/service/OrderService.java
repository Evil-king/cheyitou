package com.cheyitou.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Workbook;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.vo.OrderPagination;
import com.cheyitou.common.model.vo.OrderVO;
import com.cheyitou.common.model.vo.ResultJson;

public interface OrderService {
	
	/**
	 * list数据
	 * @param orderVO
	 * @return
	 */
	List<OrderVO> list(OrderVO orderVO);
	
	/**
	 * 分页查询
	 * @param orderPagination
	 * @return
	 */
	ResultJson<OrderVO> page(OrderPagination orderPagination);
	
	/**
	 * 统计
	 * @param orderVO
	 * @return
	 */
	int total(OrderVO orderVO);
	
	/**
	 * 操作
	 * @param flag
	 * @param status
	 * @return
	 */
	boolean operate(Integer id,boolean flag) throws BaseException;
	
	/**
	 * 导出excel
	 * @param list
	 * @param request
	 * @return
	 */
	Workbook createExcel(List<OrderVO> list, HttpServletRequest request);
	
}
