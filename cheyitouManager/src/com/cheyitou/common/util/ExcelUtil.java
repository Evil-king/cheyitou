package com.cheyitou.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.vo.OrderVO;

public class ExcelUtil {

	private static final String TITLES[] = { "订单号",  "账号", "完成提交时间", "正面图片", "背面图片", "侧面图片", "状态" };
	


	public void write(List<OrderVO> list, OutputStream output) throws BaseException{
		int rowNum = 5000;
		Workbook workbook = new HSSFWorkbook();
		// 超过5000条数据后自动切到下一个选项卡
		int sheetSize = list.size() / rowNum;
		int pl = list.size() % rowNum;

		if (pl > 0) {
			sheetSize = sheetSize + 1;
		}

		for (int i = 0; i < sheetSize; i++) {
			Sheet sheet = workbook.createSheet("第" + (i + 1) + "页");
			sheet.setColumnWidth((short)0, (short) (35.7 * 150)); 
			sheet.setColumnWidth((short)1, (short) (35.7 * 150)); 
			sheet.setColumnWidth((short)2, (short) (35.7 * 150)); 
			sheet.setColumnWidth((short)3, (short) (35.7 * 150)); 
			sheet.setColumnWidth((short)4, (short) (35.7 * 150)); 
			sheet.setColumnWidth((short)5, (short) (35.7 * 150)); 
			sheet.setColumnWidth((short)6, (short) (35.7 * 150)); 

			int num = rowNum;

			if (i == sheetSize - 1) {
				num = pl;
			}

			for (int j = 0; j < num; j++) {
				// 生成标题
				Row titleRow = sheet.createRow(0);
				for (int k = 0; k < TITLES.length; k++) {
					Cell titleCell = titleRow.createCell(k);
					titleCell.setCellValue(TITLES[k]);
				}

//				OrderVO orderVO = list.get(i * num + j);
//
//				Row row = sheet.createRow(j + 1);
//
//				Cell orderNumCell = row.createCell(0);
//				if (orderVO.getOrderNum()!=null)
//					orderNumCell.setCellValue(orderVO.getOrderNum());
//
//				Cell memberCodeCell = row.createCell(1);
//				if (orderVO.getMobilePhone()!=null)
//					memberCodeCell.setCellValue(orderVO.getMobilePhone());
//
//				Cell sellerCell = row.createCell(2);
//				sellerCell.setCellValue(DateUtil.format(orderVO.getGetModified()));
//
//				Cell frontImgeCell = row.createCell(3);
//				if (orderVO.getFrontImg() != null) {
//					frontImgeCell.setCellValue(orderVO.getFrontImg());
//				}
//				Cell backImgeCell = row.createCell(4);
//				if (orderVO.getFrontImg() != null) {
//					backImgeCell.setCellValue(orderVO.getBackImg());
//				}
//				Cell sideImgeCell = row.createCell(5);
//				if (orderVO.getFrontImg() != null) {
//					sideImgeCell.setCellValue(orderVO.getSideImg());
//				}
//				Cell statusCell = row.createCell(6);
//				if (StringUtil.isNotEmpty(orderVO.getStatus())) {
//					if(orderVO.getStatus().equals("3")){
//						statusCell.setCellValue("审核中");
//					}
//					if(orderVO.getStatus().equals("4")){
//						statusCell.setCellValue("审核失败");
//					}
//					if(orderVO.getStatus().equals("5")){
//						statusCell.setCellValue("审核成功");
//					}
//				}
			}
		}

		try {
			workbook.write(output);
			output.flush();
		} catch (Exception e) {
			throw new BaseException(e.getMessage());
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				throw new BaseException(e.getMessage());
			}
		}
	}
}
