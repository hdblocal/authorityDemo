package com.whir.springmvc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whir.springmvc.dao.RoleAccessDao;
import com.whir.springmvc.model.RoleAccess;
import com.whir.springmvc.service.RoleAccessService;


@Service
@Transactional
public class RoleAccessServiceImpl implements RoleAccessService{
	@Autowired
	private RoleAccessDao roleAccessDao ;
	
	@Override
	public void saveRoleAccess(Integer roleId, String accessIds) {
		if(accessIds.equals("")){
			
		}else{
			String [] idArr = accessIds.split(",") ;
			for(int i=0;i<idArr.length;++i){
				RoleAccess roleAccess = new RoleAccess() ;
				roleAccess.setId(new Random().nextInt(99999)) ;
				roleAccess.setRoleId(roleId) ;
				roleAccess.setAccessId(Integer.parseInt(idArr[i])) ;
				roleAccess.setCreatedTime(new Date()) ;
				roleAccessDao.save(roleAccess) ;
			}
		}
	}

	/**
	 * 根据roleId获取role所拥有的access的Id集合
	 */
	@Override
	public List getAccessIdsByRoleIdList(Integer roleId) {
		List list = roleAccessDao.getList(roleId) ;
		return list;
	}	
	
}
