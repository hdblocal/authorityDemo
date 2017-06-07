package com.whir.springmvc.dao;

import java.util.List;

import com.whir.springmvc.common.GenericDao;
import com.whir.springmvc.model.Role;

public interface RoleDao  extends GenericDao<Role, Integer>{

	public List<Role> list() ;
	public void saveRole(Role role);
	public void updateRole(Role role) ;
	public Role getRoleById(Integer id) ; 
}
