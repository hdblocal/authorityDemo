package com.whir.springmvc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whir.springmvc.dao.RoleDao;
import com.whir.springmvc.dao.UserDao;
import com.whir.springmvc.dao.UserRoleDao;
import com.whir.springmvc.model.Role;
import com.whir.springmvc.model.User;
import com.whir.springmvc.model.UserRole;
import com.whir.springmvc.service.RoleService;

@Transactional
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao ;
	
	@Autowired
	private UserDao userDao ;
	
	@Autowired
	private UserRoleDao userRoleDao ;
	
	@Override
	public List<Role> listAll() {
		return roleDao.list() ;
	}

	@Override
	public void saveRole(Role role) {
		Random random = new Random();
		role.setId(random.nextInt(1000)+random.nextInt(100)+random.nextInt(999999)) ;
		role.setCreatedTime(new Date()) ;
		role.setUpdatedTime(new Date()) ;
		role.setStatus(1) ;
		roleDao.saveRole(role) ;
	}

	@Override
	@Transactional
	public void modifyRole(Role role) { 
		role.setCreatedTime(new Date()) ;
		role.setUpdatedTime(new Date()) ;
		roleDao.updateRole(role) ;
	}

	@Override
	public Role findRoleById(Integer id) {
		return roleDao.getRoleById(id) ;
	}

	@Override
	@Transactional
	public void addUser(User user, String roleId) {
		
		try{
			Random random = new Random();
			user.setId(random.nextInt(9999)+random.nextInt(999)+random.nextInt(99999)+random.nextInt(99999)) ;
			user.setCreateTime(new Date()) ;
			user.setUpdatedTime(new Date()) ;
			userDao.save(user) ;

			Role role = roleDao.getRoleById( Integer.parseInt(roleId) ) ;
			
			UserRole userRole = new UserRole() ;
			userRole.setId(random.nextInt(9999)+random.nextInt(999)+random.nextInt(99999)+random.nextInt(99999)) ;
			userRole.setUid(user.getId()) ;
			userRole.setRole_id(Integer.parseInt(roleId)) ;
			userRole.setCreateTime(new Date()) ;
			userRoleDao.save(userRole) ;
			
		}catch(RuntimeException e){
			e.printStackTrace() ;
		}
		
	}
	
}
