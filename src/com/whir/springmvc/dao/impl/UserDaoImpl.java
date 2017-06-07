package com.whir.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.whir.springmvc.dao.UserDao;
import com.whir.springmvc.model.User;

@Component
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao{
	  
	 
	//根据id查询用户是否存在
	@Override
	public User queryUserById(Integer id) {
		return findById(User.class,id);
	}

	@Override
	public List list() {
		List list = super.find(" select u.id,u.name,u.email,u.created_time,r.name as name1 from user u " +
				"  join user_role ur on u.id = ur.uid " +
				"  join role r on r.id=ur.role_id ") ; 
				//super.find(" select a.*,c.name from user a  join user_role b on a.id=b.uid  join role c on c.id=b.role_id ") ;
				//findByHql(" SELECT u.id,u.name,u.email,r.name FROM com.whir.springmvc.model.User u " +
				//" join com.whir.springmvc.model.UserRole ur ON u.id = ur.uid" +
				//" join com.whir.springmvc.model.Role r ON r.id=ur.roleId ", null) ;
  		return list ;
	}
 
	@Override
	public void save(User user){
		super.save(user) ;
	}

	@Override
	public void delete(Integer id) {
		super.deleteById(User.class, id);
	}
}
