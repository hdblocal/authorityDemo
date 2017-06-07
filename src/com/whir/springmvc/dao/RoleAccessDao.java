package com.whir.springmvc.dao;

import java.util.List;

import com.whir.springmvc.common.GenericDao;
import com.whir.springmvc.model.RoleAccess;

public interface RoleAccessDao extends GenericDao<RoleAccess, Integer>{

	public void saveRoleAccess(RoleAccess roleAccess);//oneToMany
	public List getList(Integer roleId);
}
