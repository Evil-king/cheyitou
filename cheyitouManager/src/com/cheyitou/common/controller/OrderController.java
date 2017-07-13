package com.cheyitou.common.controller;


import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.vo.OrderPagination;
import com.cheyitou.common.model.vo.OrderVO;
import com.cheyitou.common.model.vo.ResFlag;
import com.cheyitou.common.model.vo.ResultJson;
import com.cheyitou.common.service.OrderService;
import com.cheyitou.common.util.ZipUtils;
/**
 * Order的controller
 * @author Fox
 *
 */
@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/page")
	@ResponseBody
	public ResultJson<OrderVO> page(OrderPagination orderPagination,OrderVO orderVO){
		orderPagination.setOrderVO(orderVO);
		ResultJson<OrderVO> json = orderService.page(orderPagination);
		if(json==null){
			json = new ResultJson<OrderVO>();
		}
		return json;
	}
	
	@RequestMapping(value="/operate")
	@ResponseBody
	public ResFlag toOperate(Integer id,boolean flag) throws BaseException{
		
		return new ResFlag(orderService.operate(id,flag));
	}
	
	/**
	 * 导出excel
	 * @param request
	 * @param response
	 * @param orderVO
	 * @throws BaseException
	 */
	@RequestMapping(value="/excel")
	public void exportExcle(HttpServletRequest request,HttpServletResponse response,OrderVO orderVO)throws BaseException{
		 //查询数据的list
		List<OrderVO> list = orderService.list(orderVO);
	     //使用方法生成excle模板样式  
        Workbook workbook = orderService.createExcel(list, request);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); // 定义文件名格式
        try {  
        	
                String msg = new String(  
                        ("订单_" + format.format(new Date()) + ".xls").getBytes(),  
                        "UTF-8"); 
                String zipName = "订单_" + format.format(new Date());
                ZipUtils.zip(getFile(zipName), msg, workbook);
                // 以导出时间作为文件名  
                response.setContentType("application/vnd.ms-excel");  
        		response.setHeader("Content-disposition", "attachment;filename="
        				+ URLEncoder.encode(zipName+".zip", "UTF-8"));
                workbook.write(response.getOutputStream());  
            } catch (IOException e) {  
                throw new BaseException(e.getMessage());  
            }  
	}
	
	private File getFile(String zipName){
		String targetPath = "/Users/Macx/Desktop/zip/";
		File file = new File(targetPath);
		if( !file.exists() ){
			file.mkdirs();
		}
		String fileName = zipName+".zip";
//		if( !f.exists() ){
//			try {
//				File.createTempFile(zipName, ".zip");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		return new File(targetPath+fileName);
	}
	
}
