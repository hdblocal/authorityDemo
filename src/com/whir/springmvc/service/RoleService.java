package com.whir.springmvc.service;

import java.util.List;

import com.whir.springmvc.model.Role;
import com.whir.springmvc.model.User;

public interface RoleService {

	public List<Role> listAll() ;
	public void saveRole(Role role) ;
	public void modifyRole(Role role) ;
	public Role findRoleById(Integer id) ;
	public void addUser(User user, String roleId) ;
}
