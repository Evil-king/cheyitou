package com.cheyitou.common.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cheyitou.common.dao.OrderMapper;
import com.cheyitou.common.dao.ReservationMapper;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Order;
import com.cheyitou.common.model.po.Reservation;
import com.cheyitou.common.model.vo.ReservationPagination;
import com.cheyitou.common.model.vo.ReservationVO;
import com.cheyitou.common.model.vo.ResultJson;
import com.cheyitou.common.service.ReservationService;
import com.cheyitou.common.util.DateUtil;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationMapper reservationMapper;
	@Autowired
	private OrderMapper orderMapper;

	/**
	 * 操作
	 */
	public boolean toOperat(Integer id,boolean flag,String status) throws BaseException{
		if(flag && status.equals("1")){
			Reservation res = new Reservation();
			res.setStatus("4");//前往预约
			res.setId(id);
			res.setIsToRes("1");//前往中
			if(reservationMapper.update(res) < 0){
				throw new BaseException("0","更新状态失败");
			}
			return true;
		}else if(!flag && (status.equals("3")|| status.equals("4"))){
			Reservation rev = new Reservation();
			rev.setStatus("3");//审核失败 重新预约
			rev.setId(id);
			if(reservationMapper.update(rev) < 0){
				throw new BaseException("0","更新状态失败");
			}
			return true;
		}else if(flag && status.equals("4")){
				Reservation res = new Reservation();
				res.setStatus("2");//审核成功
				res.setId(id);
				res.setExpired("1");//过期
				if(reservationMapper.update(res) < 0){
					throw new BaseException("0","更新状态失败");
				}
				//预约审核成功创建订单
				Order order = new Order();
				order.setOrderNum(DateUtil.format(new Date(), "yyyy-MM-ddHH-ss").replace("-", "")+RandomStringUtils.random(2, "1234567890"));
				order.setStatus("0");//订单状态为 有订单
				order.setResId(id);//预约id
				if(orderMapper.create(order) < 0){
					throw new BaseException("0","订单创建失败");
				}
				return true;
			}
		return true;
	}
	
	/**
	 * 预约信息list
	 */
	public List<ReservationVO> list(ReservationVO reservationVO) {
		ReservationPagination reservationPagination = new ReservationPagination();
		reservationPagination.setPage(ReservationPagination.DEFAULT_PAGE);
		reservationPagination.setRows(ReservationPagination.DEFAULT_ROWS);
		reservationPagination.setReservationVO(reservationVO);
		return reservationMapper.list(reservationPagination);
	}

	/**
	 * 统计
	 */
	public int total(ReservationVO reservationVO) {
		
		return reservationMapper.total(reservationVO);
	}

	/**
	 * page查询
	 */
	public ResultJson<ReservationVO> page(ReservationPagination pagination) {
		ResultJson<ReservationVO> json = new ResultJson<ReservationVO>();
		json.setRows(reservationMapper.list(pagination));
		json.setTotal(total(pagination.getReservationVO()));
		return json;
	}

}
