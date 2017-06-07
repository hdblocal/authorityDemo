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
	 * 对中文进行转码
	 * 
	 * @param str
	 *            中文字符串
	 * 
	 * @return 中文编码过后的的字符串
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
