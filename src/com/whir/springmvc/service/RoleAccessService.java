package com.whir.springmvc.service;

import java.util.List;


public interface RoleAccessService {

	public void saveRoleAccess(Integer roleId,String accessIds) ;
	public List getAccessIdsByRoleIdList(Integer roleId) ;
}
