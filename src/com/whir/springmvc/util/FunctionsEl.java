package com.whir.springmvc.util;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * @project XXX
 * 
 * @author : XXX
 * 
 * @version 1.0
 * 
 * @Create:2011 5:41:27 PM
 * 
 * @Update:
 * 
 * @describe:
 */

public class FunctionsEl {

	/**
	 * 
	 * �����Ľ���ת��
	 * 
	 * @param str
	 *            �����ַ���
	 * 
	 * @return ���ı������ĵ��ַ���
	 */

	public static String elEncode(String str) {

		String decodeStr = null;

		try {

			decodeStr = URLDecoder.decode(str, "utf-8");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return decodeStr;

	}

}
