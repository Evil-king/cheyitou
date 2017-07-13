package com.cheyitou.common.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.cheyitou.common.util.StringUtil;

public class DomainUtil {
	
	final static String DOMAIN = "[^\\.]+(\\.com\\.cn|\\.net\\.cn|\\.org\\.cn|\\.gov\\.cn|\\.com|\\.net|\\.cn|\\.org|\\.cc|\\.me|\\.tel|\\.mobi|\\.asia|\\.biz|\\.info|\\.name|\\.tv|\\.hk|\\.公司|\\.中国|\\.网络)";
	
	public static String getTopDomainWithoutSubdomain(String url) {
		if (StringUtil.isEmpty(url)) return null;
		
		String host;
		try {
			host = new URL(url).getHost().toLowerCase();
		} catch (MalformedURLException e) {
			
			return null;
		}
		
		Pattern pattern = Pattern.compile(DOMAIN);
		Matcher matcher = pattern.matcher(host);
		while (matcher.find()) 
			return matcher.group();
		
		return null;
	}
	
	public static String getTopDomainWithoutSubdomain(HttpServletRequest request) {
		
		return getTopDomainWithoutSubdomain(request.getRequestURL().toString());
	}
}