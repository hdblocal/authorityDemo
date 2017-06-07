
package com.whir.springmvc.service;

import java.util.List;
import com.whir.springmvc.model.Access;

public interface AccessService {

	public List<Access> listAll() ;

	public void save(Access access);

	public void deleteById(Integer id);
	
	public String getUrlsByIds(List idsList);
	
	public Access findById(Integer id);

	public List getUrlsByUid(Integer uid) ;
}
