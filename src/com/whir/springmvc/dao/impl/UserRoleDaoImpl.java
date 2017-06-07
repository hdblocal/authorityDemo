package com.whir.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.whir.springmvc.dao.UserRoleDao;
import com.whir.springmvc.model.UserRole;

@Component
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole,Integer> implements UserRoleDao {

	@Override
	public void save(UserRole userRole) {
		super.save(userRole) ;
	}
	
	@Override
	public void delete(UserRole userRole) {
		super.delete(userRole) ;
	}

	/**
	 * 根据用户id查询所有的所属的角色id集合
	 */
	@Override
	public List queryByUid(Integer id) {
		return super.currentSession().createSQLQuery(" SELECT * FROM user_role WHERE uid = "+id).
				addEntity(UserRole.class).list() ;
	}
}
