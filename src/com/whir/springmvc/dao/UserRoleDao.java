package com.whir.springmvc.dao;

import java.util.List;

import com.whir.springmvc.common.GenericDao;
import com.whir.springmvc.model.UserRole;

public interface UserRoleDao extends GenericDao<UserRole, Integer>{

	public void save(UserRole userRole) ;
	public void delete(UserRole userRole) ;
	public List queryByUid(Integer id) ;
}
