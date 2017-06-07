package com.whir.springmvc.service;

import java.util.List;

import com.whir.springmvc.model.User;

public interface UserService {

	public User queryUserById(Integer id);
	public List listAll() ;
	public void saveUser(User user);
	public void deleteUser(Integer id) ;
}
