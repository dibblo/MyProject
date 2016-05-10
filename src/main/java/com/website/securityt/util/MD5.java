package com.website.securityt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sum.misc.BASE64Encoder;

public class MD5 {
	public static String PRFIX = "latiflan";
	public static String getMD5(String data){
		
		String result = null;
		MessageDigest mdt = null;
		try {
			mdt = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes = (PRFIX + data).getBytes();
		byte[] targetBytes = mdt.digest(bytes);
		BASE64Encoder base64en = new BASE64Encoder();
		String newstr=base64en.encode(mdt.digest((PRFIX+data).getBytes("UTF-8")));
		return newstr;
	}
}
