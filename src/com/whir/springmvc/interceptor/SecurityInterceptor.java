package com.whir.springmvc.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {
	
	//不需要拦截的url
	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	/**
	 * 这个方法在DispatcherServlet完全处理完请求后被调用，可以在该方法中进行一些资源清理的操作。
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
		
	}

	/**
	 * 这个方法在业务处理器处理完请求后，但是DispatcherServlet向客户端返回请求前被调用，在该方法中对用户请求request进行处理。
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView modelAndView) throws Exception {
		
	}

	/**
	 * 这个方法在业务处理器处理请求之前被调用，在该方法中对用户请求request进行处理。
	 * 如果程序员决定该拦截器对请求进行拦截处理后还要调用其他的拦截器，或者是业务处理器去进行处理，则返回true；
	 * 如果程序员决定不需要再调用其他的组件去处理请求，则返回false。
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		System.out.println("---------拦截____url----------");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length()+1);
		
		//如果是系统管理员  不执行拦截
		//roleId--->6 uid--->11
		String uid = (String) request.getSession().getAttribute("uid") ;
		if( uid!=null && uid.equals("11") ){
			return true ;
		}
		
		//一些特定页面不进行拦截
		if(url.indexOf("index")!=-1 || url.indexOf("login")!=-1 || excludeUrls.contains(url)){
			return true ;
		}
		
		PrintWriter out = response.getWriter() ;
		//暂时只对点击事件进行拦截
		//从session中获取用户所能点击的url
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
		//判断用户登录 是否合法
		String cookie = CookieTool.getCookieValueByName(request, "jsession") ;
		if(cookie==null){
			return false ;
		}else{
			String id = cookie.substring(cookie.indexOf("#")+1,cookie.length()) ;
			String verifyCode = cookie.substring(0,cookie.indexOf("#")) ;
			//判断cookie是否合法
			MD5 md5 = new MD5() ;
			//cookie合法
			if( md5.getMD5ofStr( String.valueOf( id ) ).equals(verifyCode) ){
				//判断用户是否有权限访问该url
				if(true){
					return true ;
				}
			}else{
				return false ;
			}
		}*/
		 
	}

}
