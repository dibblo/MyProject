package com.base.security.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.applet.Main;
import sun.misc.BASE64Encoder;

public class MD5 {
	public static String PRFIX = "latiflan";
	public static String getMD5(String data){
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
		String newstr="";
		try {
			newstr = base64en.encode(mdt.digest((PRFIX+data).getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newstr;
	}

	public static void main(String args[]){
		MD5.getMD5("sys");
		System.out.println(MD5.getMD5("sys"));
	}
}
