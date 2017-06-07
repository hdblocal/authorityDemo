package com.whir.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whir.springmvc.model.Access;
import com.whir.springmvc.model.Role;
import com.whir.springmvc.model.RoleAccess;
import com.whir.springmvc.service.AccessService;
import com.whir.springmvc.service.RoleAccessService;
import com.whir.springmvc.service.UserRoleService;

@Controller
@RequestMapping("/access")
public class AccessController {

	@Autowired
	private AccessService accessService ;
	
	@Autowired
	private UserRoleService userRoleService ;
	
	@Autowired
	private RoleAccessService roleAccessService ;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List<Access> accessList = accessService.listAll() ;
		request.setAttribute("accessList", accessList) ;
		return "access/list";
	}
	
	@RequestMapping("/add")
	public String add(){
		return "access/add" ;
	}
	
	@RequestMapping("/save")
	public String save(Access access){
		accessService.save(access);
		return "redirect:/access/list" ;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")String id){
		accessService.deleteById( Integer.parseInt(id) ) ;
		return "redirect:/access/list" ;
	}
	
	@RequestMapping("/url/{uid}")
	public String getUrls(@PathVariable("uid")Integer uid){
		List list = accessService.getUrlsByUid(uid) ;
		Access access = null ;
		StringBuffer sb = new StringBuffer() ;
		for(int i=0;i<list.size();++i){
			access = (Access) list.get(i) ;
			sb.append(access.getUrls()+",") ;
		} 
		return null ;
	}
	
}
