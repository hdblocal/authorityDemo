package com.whir.springmvc.dao;

import java.util.List;

import com.whir.springmvc.common.GenericDao;
import com.whir.springmvc.model.User;

public interface UserDao extends GenericDao<User, Integer>{

	public User queryUserById(Integer id);
	public List list();
	public void save(User user);
	public void delete(Integer id);
}
