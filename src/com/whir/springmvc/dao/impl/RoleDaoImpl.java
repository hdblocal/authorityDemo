package com.whir.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.whir.springmvc.dao.RoleDao;
import com.whir.springmvc.model.Role;

@Component
public class RoleDaoImpl extends GenericDaoImpl<Role,Integer> implements RoleDao {

	@Override
	public List<Role> list() {
		return findAll(Role.class) ;
	}

	@Override
	public void saveRole(Role role) {
		super.save(role);
	}

	@Override
	public void updateRole(Role role) { 
		super.update(role) ;
	}

	public Role getRoleById(Integer id){
		return super.findById(Role.class, id);
	}
 
}
