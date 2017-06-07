package com.whir.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whir.springmvc.model.Access;
import com.whir.springmvc.model.Role;
import com.whir.springmvc.model.User;
import com.whir.springmvc.service.AccessService;
import com.whir.springmvc.service.RoleService;
import com.whir.springmvc.service.UserService;
import com.whir.springmvc.util.CookieTool;
import com.whir.springmvc.util.MD5;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService ;
	
	@Autowired
	private RoleService roleService ;
	
	@Autowired
	private AccessService accessService ;
	
	/**
	 * 伪登录---需要校验码
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/login/{id}")
	public String login(@PathVariable("id")Integer id,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{ 
		//根据id查找是否有此用户
		User user = userService.queryUserById(id) ;
		if(user==null){
			return "error" ;
		}else{
			//保存用户信息到cookie,cookie需要加密
			//user_auth_token+"#"+uid
			//MD5. 
			MD5 m = new MD5();
			String user_auth_token = m.getMD5ofStr( String.valueOf( id ) );
			CookieTool.addCookie(response, "jsession", user_auth_token+"#"+id, 1000) ;
			CookieTool.addCookie(response, "username", URLEncoder.encode(user.getName(),"UTF-8"), 1000) ;
			return "index" ;
		}
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List  userList = userService.listAll() ;
		request.setAttribute("userList", userList) ;
		
		return "user/list" ;
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")String id,HttpServletRequest request){
		User user = userService.queryUserById(Integer.parseInt(id)) ;
		request.setAttribute("user", user) ;
		return "user/edit" ;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request){
		List<Role> roleList = roleService.listAll() ;
		request.setAttribute("roleList", roleList) ;
		return "user/add" ;
	}
	
	@RequestMapping("/save")
	public String save(User user,String roleId){
		roleService.addUser(user,roleId) ;
		return "redirect:/user/list" ;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")String id){
		userService.deleteUser( Integer.parseInt(id) ) ;
		return "redirect:/user/list" ;
	}
}
