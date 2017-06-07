package com.whir.springmvc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whir.springmvc.dao.UserDao;
import com.whir.springmvc.dao.UserRoleDao;
import com.whir.springmvc.model.User;
import com.whir.springmvc.model.UserRole;
import com.whir.springmvc.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao ;
	
	@Autowired
	private UserRoleDao userRoleDao ;
	
	@Override
	public User queryUserById(Integer id) {
		return userDao.queryUserById(id) ;
	}

	@Override
	public List listAll() {
		return userDao.list() ;
	}

	@Override
	public void saveUser(User user) {
		Random random = new Random() ;
		user.setId(random.nextInt(9999)+random.nextInt(99999)+random.nextInt(99999)+random.nextInt(99999)) ;
		user.setCreateTime(new Date()) ;
		user.setUpdatedTime(new Date()) ;
		userDao.save(user) ;
	}

	@Override
	@Transactional
	public void deleteUser(Integer id) {
		userDao.delete(id) ;
		//删除用户的同时，删除用户在userRole中的关联
		//一个用户对应多个角色
		UserRole ur = null ;
		List<UserRole> list = userRoleDao.queryByUid(id) ;
		for(int i=0;list!=null && i<list.size();++i){
			ur = (UserRole)list.get(i) ;
			userRoleDao.delete(ur) ;
		}
	}
	
}
