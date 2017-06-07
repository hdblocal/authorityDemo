package com.whir.springmvc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whir.springmvc.dao.AccessDao;
import com.whir.springmvc.model.Access;
import com.whir.springmvc.service.AccessService;

@Transactional
@Service
public class AccessServiceImpl implements AccessService{

	@Autowired
	private AccessDao accessDao ;
	
	@Override
	public List<Access> listAll() {
		return accessDao.list() ;
	}

	@Override
	public void save(Access access) {
		access.setId(new Random().nextInt(99999)) ;
		access.setStatus(1) ;
		access.setCreatedTime(new Date()) ;
		access.setUpdateTime(new Date()) ;
		accessDao.save(access) ;
	}

	@Override
	public void deleteById(Integer id) {
		accessDao.deleteById(id) ;
	}

	/**
	 * ����id���ϲ�ѯ���е�urls
	 */
	@Override
	public String getUrlsByIds(List idsList) {
		StringBuffer result = new StringBuffer() ;
		List list = null ;
		for(int i=0;i<idsList.size();++i){
			String id = idsList.get(i)+"" ;
			list = accessDao.getUrlsById( Integer.valueOf(id) ) ;
			if(list!=null){
				result.append(list.get(0)+",") ;
			}
		}
		if(result!=null && !result.equals("")){
			result.substring(0, result.length()-1) ;
		}
		return result+"";
	}

	@Override
	public Access findById(Integer id) {
		return accessDao.findById(id);
	}

	/**
	 * ����uid��ѯ�û���ӵ�е�urlȨ��
	 * �����еĲ�ѯ���ϳ�һ��
	 * ԭ�����ѷ���
	 */
	@Override
	public List getUrlsByUid(Integer uid) {
		return accessDao.getUrlsByUid(uid);
	}
 
}