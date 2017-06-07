package com.whir.springmvc.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTool {
    /**
     * ���cookie
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge ��Чʱ��
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        //cookie.setDomain(".189.cn"); // cookie������
        response.addCookie(cookie);
    }

    /**
     * ��������cookie ��װ��map���� ����cookie name��Ϊkey cookie value��Ϊvalue
     * 
     * @param request
     * @return
     */
    public static Map<String, String> ReadCookieMap(HttpServletRequest request) {
        Map<String, String> cookieMap = new HashMap<String, String>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }

    /**
     * ͨ��cookie name ��ȡ cookie value
     * 
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValueByName(HttpServletRequest request, String name) {
        Map<String, String> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            String cookieValue = (String) cookieMap.get(name);
            return cookieValue;
        } else {
            return null;
        }
    }

}