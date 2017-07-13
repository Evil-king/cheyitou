package com.cheyitou.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
/**
 * Zip工具类
 * @author Fox
 *
 */
public class ZipUtils {
	public static void zip(File targetFile, String msg,Workbook... wbs) {
		if (wbs == null || wbs.length == 0) {
			return;
		}
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(new FileOutputStream(targetFile));
			for (int i = 0; i < wbs.length; i++) {
				ZipEntry entry = new ZipEntry(msg);
				// 设置压缩包的入口
				zos.putNextEntry(entry);
				wbs[i].write(zos);
				zos.flush();
			}
			zos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
