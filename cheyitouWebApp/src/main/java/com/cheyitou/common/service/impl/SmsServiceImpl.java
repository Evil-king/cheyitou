package com.cheyitou.common.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheyitou.common.dao.mapper.SmsMapper;
import com.cheyitou.common.exception.BaseException;
import com.cheyitou.common.model.po.Sms;
import com.cheyitou.common.service.SmsService;
import com.cheyitou.common.util.MD5;
@Service
public class SmsServiceImpl implements SmsService {
	
	@Autowired
	private SmsMapper smsMapper;

	private static final String smsSvcUrl = "http://43.243.130.33:8860";	  //服务器URL 地址
	private static final String cust_code = "810100";					 //账号
	private static final String password = "94DVSG95HQ";		 			 //密码
	private static final String sp_code = "";                  //接入码（扩展码）
	
	public static final String Template_code = "您的验证码是:%s。如非本人操作，请忽略本短信。该验证码将在30分钟后失效。";
	public static final String Template_passwd = "您的新密码是:%s。请注意查收。该验证码将在30分钟后失效。";
	
	public void sendSms(String mobiles, String content) throws BaseException {
		sendSms(mobiles, content, sp_code, 0);
	}

	public void sendSms(String mobiles, String content, long task_id) throws BaseException {
		sendSms(mobiles, content, sp_code, task_id);

	}

	public void sendSms(String mobiles, String content, String sp_code) throws BaseException {
		sendSms(mobiles, content, sp_code, 0);

	}
	
	public void sendSms(String mobiles, String content, String sp_code,
			long task_id) throws BaseException {
		try {
			String urlencContent = URLEncoder.encode(content,"utf-8");
			String sign=MD5.sign(urlencContent, password, "utf-8");
			String postData = "content=" + urlencContent + "&destMobiles="
					+ mobiles + "&sign=" + sign + "&cust_code=" + cust_code
					+ "&sp_code=" + sp_code + "&task_id=" + task_id;
//			System.err.println("postData:"+postData);
			URL myurl = new URL(smsSvcUrl);
			URLConnection urlc = myurl.openConnection();
			urlc.setReadTimeout(1000 * 30);
			urlc.setDoOutput(true);
			urlc.setDoInput(true);
			urlc.setAllowUserInteraction(false);

			DataOutputStream server = new DataOutputStream(urlc.getOutputStream());
			//System.out.println("发送数据=" + postData);

			server.write(postData.getBytes("utf-8"));
			server.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlc.getInputStream(), "utf-8"));
			String resXml = "", s = "";
			while ((s = in.readLine()) != null)
				resXml = resXml + s + "\r\n";
			in.close();
//			System.out.println("接收数据=" + URLDecoder.decode(resXml,"utf-8"));
			/**
			 * 自定义的存储短信数据方法
			 */
			saveSms(mobiles,content,postData,resXml);
		} catch (Exception e) {
			throw new BaseException("调用短信接口异常!");
		}
	}
	
	/**
	 * 自定义的存储短信数据方法
	 * @param mobiles
	 * @param content
	 * @param postData
	 * @param resXml
	 */
	public void saveSms(String mobiles,String content,String postData,String resXml){
		Sms sms = new Sms();
		sms.setPhone(mobiles);
		sms.setContent(content);
		sms.setPost_data(postData);
		sms.setRes_xml(resXml);
		int num = smsMapper.create(sms);
	}
	
	
//	public static void main(String[] args) throws IOException {
//		SmsServiceImpl ss = new SmsServiceImpl();
//		ss.sendSms("13755588979", "欢迎注册空竹科技");
//		String.format(Template_code, "123456");
//	}
}
