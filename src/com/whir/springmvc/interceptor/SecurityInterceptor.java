package com.whir.springmvc.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {
	
	//����Ҫ���ص�url
	private List<String> excludeUrls;// ����Ҫ���ص���Դ

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	/**
	 * ���������DispatcherServlet��ȫ����������󱻵��ã������ڸ÷����н���һЩ��Դ����Ĳ�����
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
		
	}

	/**
	 * ���������ҵ����������������󣬵���DispatcherServlet��ͻ��˷�������ǰ�����ã��ڸ÷����ж��û�����request���д���
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView modelAndView) throws Exception {
		
	}

	/**
	 * ���������ҵ��������������֮ǰ�����ã��ڸ÷����ж��û�����request���д���
	 * �������Ա������������������������ش����Ҫ������������������������ҵ������ȥ���д����򷵻�true��
	 * �������Ա��������Ҫ�ٵ������������ȥ���������򷵻�false��
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		System.out.println("---------����____url----------");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length()+1);
		
		//�����ϵͳ����Ա  ��ִ������
		//roleId--->6 uid--->11
		String uid = (String) request.getSession().getAttribute("uid") ;
		if( uid!=null && uid.equals("11") ){
			return true ;
		}
		
		//һЩ�ض�ҳ�治��������
		if(url.indexOf("index")!=-1 || url.indexOf("login")!=-1 || excludeUrls.contains(url)){
			return true ;
		}
		
		PrintWriter out = response.getWriter() ;
		//��ʱֻ�Ե���¼���������
		//��session�л�ȡ�û����ܵ����url
		String canAccessUrl = (String) request.getSession().getAttribute("canAccessUrl") ;
		System.out.println("url-------->"+url);
		System.out.println("canAccessUrl------->"+canAccessUrl);
		if(canAccessUrl.indexOf(url)!=-1){
			return true ;
		}else{
			out.print("<script>alert('no right to do this...')</script>");
			return false ;
		}
		
		/*if(url.indexOf("login")!=-1 || excludeUrls.contains(url)){
			return true ;
		}
		//�ж��û���¼ �Ƿ�Ϸ�
		String cookie = CookieTool.getCookieValueByName(request, "jsession") ;
		if(cookie==null){
			return false ;
		}else{
			String id = cookie.substring(cookie.indexOf("#")+1,cookie.length()) ;
			String verifyCode = cookie.substring(0,cookie.indexOf("#")) ;
			//�ж�cookie�Ƿ�Ϸ�
			MD5 md5 = new MD5() ;
			//cookie�Ϸ�
			if( md5.getMD5ofStr( String.valueOf( id ) ).equals(verifyCode) ){
				//�ж��û��Ƿ���Ȩ�޷��ʸ�url
				if(true){
					return true ;
				}
			}else{
				return false ;
			}
		}*/
		 
	}

}
