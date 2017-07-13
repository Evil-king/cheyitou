package com.cheyitou.common.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheyitou.common.dao.OrderMapper;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Order;
import com.cheyitou.common.model.vo.OrderPagination;
import com.cheyitou.common.model.vo.OrderVO;
import com.cheyitou.common.model.vo.ResultJson;
import com.cheyitou.common.model.vo.ResultPagination;
import com.cheyitou.common.service.OrderService;
import com.cheyitou.common.util.DateUtil;
import com.cheyitou.common.util.StringUtil;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;

	/**
	 * list数据显示
	 */
	public List<OrderVO> list(OrderVO orderVO) {
		OrderPagination orderPagination = new OrderPagination();
		orderPagination.setPage(ResultPagination.DEFAULT_PAGE);
		orderPagination.setRows(ResultPagination.DEFAULT_ROWS);
		orderPagination.setOrderVO(orderVO);
		return orderMapper.list(orderPagination);
	}

	/**
	 * page查询
	 */
	public ResultJson<OrderVO> page(OrderPagination orderPagination) {
		ResultJson<OrderVO> json = new ResultJson<OrderVO>();
		json.setRows(orderMapper.list(orderPagination));
		json.setTotal(total(orderPagination.getOrderVO()));
		return json;
	}
	
	/**
	 * 统计
	 */
	public int total(OrderVO orderVO) {
		
		return orderMapper.total(orderVO);
	}

	/**
	 * 操作
	 */
	public boolean operate(Integer id,boolean flag) throws BaseException{
		if(flag){  //订单审核成功
			Order order = new Order();
			order.setStatus("5");
			order.setId(id);
			if(orderMapper.update(order) < 0){
				throw new BaseException("更新订单状态失败");
			}
			return true;
		}
		if(!flag){  //订单审核失败
			Order order = new Order();
			order.setStatus("4");
			order.setId(id);
			if(orderMapper.update(order) < 0){
				throw new BaseException("更新订单状态失败");
			}
		}
		return true;
	}

	/**
	 * 导出excel
	 */
	public Workbook createExcel(List<OrderVO> list, HttpServletRequest request) {
		
		String TITLES[] = { "订单号",  "账号", "完成提交时间", "正面图片", "背面图片", "侧面图片", "状态" };
		
		// 创建一个webbook，对应一个excel文件  
        Workbook workbook = new HSSFWorkbook();  
        // 在webbook中添加一个sheet,对应excel文件中的sheet  
        Sheet sheet = workbook.createSheet("客户信息表");  
        // 设置列宽  
        sheet.setColumnWidth((short)0, (short) (35.7 * 150)); 
		sheet.setColumnWidth((short)1, (short) (35.7 * 150)); 
		sheet.setColumnWidth((short)2, (short) (35.7 * 150)); 
		sheet.setColumnWidth((short)3, (short) (35.7 * 150)); 
		sheet.setColumnWidth((short)4, (short) (35.7 * 150)); 
		sheet.setColumnWidth((short)5, (short) (35.7 * 150)); 
		sheet.setColumnWidth((short)6, (short) (35.7 * 150)); 
		
        // 在sheet中添加表头第0行  
        Row row = sheet.createRow(0);  
        // 创建单元格，并设置表头，设置表头居中
        for (int k = 0; k < TITLES.length; k++) {
			Cell titleCell = row.createCell(k);
			titleCell.setCellValue(TITLES[k]);
		}
  
        for (int i = 0; i < list.size(); i++) {  
            row = sheet.createRow(i + 1);  
            OrderVO orderVO = list.get(i);  
            // 创建单元格，并设置值  
            // 编号列居左  
            Cell orderNumCell = row.createCell(0);  
            if (orderVO.getOrderNum()!=null)
				orderNumCell.setCellValue(orderVO.getOrderNum());  
            
            Cell memberCodeCell = row.createCell(1);  
            if (orderVO.getMobilePhone()!=null)
				memberCodeCell.setCellValue(orderVO.getMobilePhone());  
  
            Cell sellerCell = row.createCell(2);
			sellerCell.setCellValue(DateUtil.format(orderVO.getGetModified()));

			Cell frontImgeCell = row.createCell(3);
			if (orderVO.getFrontImg() != null) {
				frontImgeCell.setCellValue(orderVO.getFrontImg());
			}
			Cell backImgeCell = row.createCell(4);
			if (orderVO.getFrontImg() != null) {
				backImgeCell.setCellValue(orderVO.getBackImg());
			}
			Cell sideImgeCell = row.createCell(5);
			if (orderVO.getFrontImg() != null) {
				sideImgeCell.setCellValue(orderVO.getSideImg());
			}
			Cell statusCell = row.createCell(6);
			if (StringUtil.isNotEmpty(orderVO.getStatus())) {
				if(orderVO.getStatus().equals("3")){
					statusCell.setCellValue("审核中");
				}
				if(orderVO.getStatus().equals("4")){
					statusCell.setCellValue("审核失败");
				}
				if(orderVO.getStatus().equals("5")){
					statusCell.setCellValue("审核成功");
				}
			}
  
        }  
        return workbook;  
	}

}
