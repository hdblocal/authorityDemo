package com.whir.springmvc.dao;

import java.util.List;

import com.whir.springmvc.common.GenericDao;
import com.whir.springmvc.model.Access;

public interface AccessDao extends GenericDao<Access, Integer>{

	public List<Access> list() ;
	public void save(Access accesss) ;
	public void deleteById(Integer id);
	public List getUrlsById(Integer id) ;
	public Access findById(Integer id);
	public List getUrlsByUid(Integer uid);
}
