package com.whir.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whir.springmvc.model.Access;
import com.whir.springmvc.model.User;
import com.whir.springmvc.service.AccessService;
import com.whir.springmvc.service.UserService;

@Controller
public class IndexCotroller {
	
	@Autowired
	private AccessService accessService ;

	@Autowired
	private UserService userService ;
	
	@RequestMapping("/index/{id}")
	public String index(@PathVariable("id")Integer id,HttpServletRequest request){
		//判断用户id是否存在
		User user = userService.queryUserById(id) ;
		StringBuffer sb = new StringBuffer() ;
		if( user!=null ){
			//获取用户所有的能操作的url
			List list = accessService.getUrlsByUid(id) ;
			Access access = null ;
			for(int i=0;i<list.size();++i){
				access = (Access) list.get(i) ;
				sb.append(access.getUrls()+",") ;
			} 
		}
		request.getSession().setAttribute("canAccessUrl", sb+"") ;
		request.getSession().setAttribute("uid", id+"") ;
		
		//获取所有的权限列表
		List<Access> accessList = accessService.listAll() ;
		request.setAttribute("accessList", accessList) ;
		
		return "index" ;
	}
}
