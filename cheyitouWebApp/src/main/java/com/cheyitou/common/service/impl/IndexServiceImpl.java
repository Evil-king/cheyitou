package com.cheyitou.common.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheyitou.common.dao.mapper.OrderMapper;
import com.cheyitou.common.dao.mapper.PersonMapper;
import com.cheyitou.common.dao.mapper.ReservationMapper;
import com.cheyitou.common.util.DateUtil;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Order;
import com.cheyitou.common.model.po.Person;
import com.cheyitou.common.model.po.Reservation;
import com.cheyitou.common.po.vo.IndexVO;
import com.cheyitou.common.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ReservationMapper reservationMapper;

	/**
	 * 首页数据
	 */
	public IndexVO toIndex(Integer userId) {
		IndexVO indexVO = new IndexVO();
		Person  pp  = personMapper.queryByUserId(userId);
		Reservation rv = reservationMapper.queryByUserId(userId);
		if(pp==null){
			throw new BaseException("300008", "请尽快完善个人信息");
		}
		indexVO.setName(pp.getName());
		indexVO.setImg(pp.getImage());
		
		if(rv!=null){
			if(rv.getStatus().equals("0")){
				indexVO.setCode("1");
				indexVO.setMsg("可以预约");
				return indexVO;
			}
			if(rv.getStatus().equals("1")){
				indexVO.setCode("2");
				indexVO.setMsg("预约中，待审核");
				return indexVO;
			}
			if(rv.getStatus().equals("3")){
				indexVO.setCode("5");
				indexVO.setMsg("预约失败，请重新预约");
				rv.setExpired("1");//预约失败把预约过期的状态改为1 过期
				rv.setUserId(userId);
				rv.setStatus("0");//预约状态变成  0可以预约
				reservationMapper.update(rv);
				return indexVO;
			}
			if(rv.getStatus().equals("4")){
				indexVO.setCode("8");
				indexVO.setMsg("前往审核");
				return indexVO;
			}
		}
		if(rv == null){
			Order or= orderMapper.queryByUserId(userId);
			Reservation res = reservationMapper.queryToStatus(userId,or.getResId());
			
			if(res.getStatus().equals("2") && or.getStatus().equals("0")){
				Date date = DateUtil.addDate(res.getGoTime(), 31);
				int days = DateUtil.diffDate(date, new Date());
				indexVO.setDays(days);
				indexVO.setOrderNum(or.getOrderNum());//放入订单编号
				indexVO.setCode("3");
				indexVO.setMsg("有订单");
				return indexVO;
			}
			if(or.getStatus().equals("2")){//解除订单
				indexVO.setCode("1");
				indexVO.setMsg("可以预约");
				return indexVO;
			}
			if(or.getStatus().equals("1")||or.getStatus().equals("3")){//订单完成，待审核
				indexVO.setCode("4");
				indexVO.setOrderNum(or.getOrderNum());
				indexVO.setStr("已提出完成申请，正在复核。复核完成后我们会将费用直接支付至您的账户余额中。请耐心等待，谢谢");
				indexVO.setReviewImage(or.getFrontImg()+","+or.getBackImg()+","+or.getSideImg());
				indexVO.setMsg("订单提交，待审核 ");
				return indexVO;
			}
			if(or.getStatus().equals("4")){//审核失败
				indexVO.setCode("6");
				indexVO.setOrderNum(or.getOrderNum()+"复核未通过,请重新提交完成订单");
				indexVO.setReviewImage(or.getFrontImg()+","+or.getBackImg()+","+or.getSideImg());
				indexVO.setMsg("订单复核失败");
				return indexVO;
			}
			if(or.getStatus().equals("5")){//审核通过
				indexVO.setCode("1");
				indexVO.setReviewImage(or.getFrontImg()+","+or.getBackImg()+","+or.getSideImg());
				indexVO.setStr(or.getOrderNum()+"已复核完成。本订单的收益金额为"+or.getAccountBalance()+"元。");
				indexVO.setMsg("您的订单已经复核成功");
				return indexVO;
			}
		}
		
		return indexVO;
	}
}
