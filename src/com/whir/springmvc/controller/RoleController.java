package com.whir.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whir.springmvc.model.Access;
import com.whir.springmvc.model.Role;
import com.whir.springmvc.service.AccessService;
import com.whir.springmvc.service.RoleAccessService;
import com.whir.springmvc.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService ;
	
	@Autowired
	private AccessService accessService ;
	
	@Autowired
	private RoleAccessService roleAccessService ;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List<Role> roleList = roleService.listAll() ;
		request.setAttribute("roleList", roleList) ;
		return "role/list" ;
	}
	
	@RequestMapping("/add")
	public String add(){
		return "role/add" ;
	}
	
	@RequestMapping("/save")
	public String save(Role role){
		roleService.saveRole(role) ;
		return "redirect:/role/list" ;
	}
	
	@RequestMapping("/update")
	public String update(Role role){
		roleService.modifyRole(role) ;
		return "redirect:/role/list" ;
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")String id,HttpServletRequest request){
		Role role = roleService.findRoleById(Integer.valueOf(id)) ;
		request.setAttribute("role", role) ;
		return "role/edit" ;
	}
	
	@RequestMapping("/eidtAccess/{id}")
	public String editAccess(@PathVariable("id")String id,HttpServletRequest request){
		request.setAttribute("roleId", id) ;
		List<Access> accessList = accessService.listAll() ;
		request.setAttribute("accessList", accessList) ;
		return "role/editAccess" ;
	}
	
	@RequestMapping("/saveAccess")
	public String saveAccess(String roleId,String accessId){ 
		roleAccessService.saveRoleAccess(Integer.parseInt(roleId),accessId);
		return "redirect:/role/list" ;
	}
}
