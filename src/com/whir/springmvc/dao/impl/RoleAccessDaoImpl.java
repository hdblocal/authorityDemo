package com.whir.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.whir.springmvc.dao.RoleAccessDao;
import com.whir.springmvc.model.RoleAccess;
import com.whir.springmvc.model.UserRole;

@Component
public class RoleAccessDaoImpl extends GenericDaoImpl<RoleAccess, Integer> implements RoleAccessDao{

	@Override
	public void saveRoleAccess(RoleAccess roleAccess) {
		super.save(roleAccess) ;
	}

	@Override
	public List getList(Integer roleId) {
		return super.currentSession().createSQLQuery(" SELECT * FROM RoleAccess WHERE role_id="+roleId) .
				addEntity(RoleAccess.class).list() ;
	}
	 
}
