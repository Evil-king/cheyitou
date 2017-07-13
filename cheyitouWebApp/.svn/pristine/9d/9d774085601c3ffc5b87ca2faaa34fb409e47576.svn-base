/**
 * Copyright 2014-2017 www.lychee.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 2.0
 * @date 2015-12-01
 */
package com.cheyitou.common.util;

import java.security.MessageDigest;

/**
 * Secure Hash Algorithm，安全散列算法
 * 
 * @author Flouny.Caesar
 *
 */
public class SHA256 {
	
	private static final String ALGORITHM = "SHA-256";
	
	/**
	 * 
	 * @param orignal
	 * @return
	 */
	public static String encrypt(String orignal) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
			byte[] origBytes = orignal.getBytes();
			messageDigest.update(origBytes);
			
            byte[] digestRes = messageDigest.digest();
            
            return getDigestStr(digestRes);
            
		} catch (Exception e) {
			// ...
		}
		
		return null;
	}
	
	private static String getDigestStr(byte[] origBytes) {
		String tempStr = null;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < origBytes.length; i++) {
        	tempStr = Integer.toHexString(origBytes[i] & 0xff);
            if (tempStr.length() == 1) 
            	stb.append("0");
            
            stb.append(tempStr);

        }
        
        return stb.toString();
	}
}