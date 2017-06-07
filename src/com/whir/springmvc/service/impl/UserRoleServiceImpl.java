package com.whir.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whir.springmvc.dao.UserRoleDao;
import com.whir.springmvc.service.UserRoleService;

@Transactional
@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private UserRoleDao userRoleDao ;
	
	@Override
	public List getRoleIdsByUid(Integer uid) {
		return userRoleDao.queryByUid(uid);
	}
	
}
