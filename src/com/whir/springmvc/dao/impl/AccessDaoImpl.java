package com.whir.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.whir.springmvc.dao.AccessDao;
import com.whir.springmvc.model.Access;
import com.whir.springmvc.model.UserRole;

@Component
public class AccessDaoImpl  extends GenericDaoImpl<Access, Integer> implements AccessDao{

	@Override
	public List<Access> list() {
		return super.findAll(Access.class) ;
	}

	@Override
	public void save(Access accesss) {
		super.save(accesss) ;
	}

	@Override
	public void deleteById(Integer id) {
		super.deleteById(Access.class, id) ;
	}

	@Override
	public List getUrlsById(Integer id) {
		List list = super.find(" SELECT urls FORM ACCESS ") ;
		return list;
	}

	@Override
	public Access findById(Integer id) {
		return super.findById(Access.class, id) ;
	}

	@Override
	public List getUrlsByUid(Integer uid) {
		String sql = "select a.* from access a " +
						"inner join role_access ra on a.id=ra.access_id " +
						"INNER JOIN user_role ur on ur.role_id=ra.role_id " +
						"where ur.uid="+uid ;
		return super.currentSession().createSQLQuery(sql).addEntity(Access.class).list() ;
	}
	
}
