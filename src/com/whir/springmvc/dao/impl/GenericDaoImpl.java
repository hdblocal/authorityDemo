package com.whir.springmvc.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.whir.springmvc.common.GenericDao;
import com.whir.springmvc.dao.MyHibernateDaoSupport;
  

@SuppressWarnings("unchecked")  
@Repository("genericDao")   //声明此类为数据持久层的类  
public class GenericDaoImpl<T extends Serializable, PK extends Serializable> extends  
                                    MyHibernateDaoSupport implements GenericDao<T, PK> {  
  
    public void delete(T entity) {  
        super.getHibernateTemplate().delete(entity);  
    }  
  
  
    public void deleteById(Class entityClass, PK id) {  
        super.getHibernateTemplate().delete(findById(entityClass, id));  
  
    }  
      
    public void save(T entity) {  
        super.getHibernateTemplate().save(entity);  
  
    }  
  
    public void saveorupdate(T entity) {  
        super.getHibernateTemplate().saveOrUpdate(entity);  
  
    }  
  
    public void update(String hql, Object[] params) {  
             Query query = super.currentSession().createQuery(hql);//  getSession().createQuery(hql);  
                for(int i=0; i<params.length; i++){  
                    query.setParameter(i, params[i]);  
                }  
                query.executeUpdate();  
     }  
      
  
    public List<T> findAll(Class entityClass) {   
        return super.getHibernateTemplate().loadAll(entityClass);  
    }  
  
    public List<T> findAll(Class entityClass, String hql, Object[] params,int start, int limit) {  
        Query query = super.currentSession().createQuery(hql); //getSession().createQuery(hql);  
        if(params!=null&&params.length>0){  
            for(int i = 0;i<params.length;i++){  
                query.setParameter(i, params[i]);  
            }  
        }  
        if(start!=0&&limit!=0){  
            query.setFirstResult(start).setMaxResults(limit);  
        }  
        return query.list();  
    }  
  
    public List<T> findByExample(T entity) {  
        return super.getHibernateTemplate().findByExample(entity);  
    }  
  
    public List<T> findByHql(String hql, Object[] params) {  
        Query query = super.currentSession().createQuery(hql); //getSession().createQuery(hql);  
        if(null!= params && params.length>0){  
            for(int i = 0; i<params.length;i++){  
                query.setParameter(i, params[i]);  
            }  
        }  
        return query.list();  
    }  
  
    public T findById(Class entityClass, PK id) {  
        return (T)super.getHibernateTemplate().get(entityClass, id);  
    }  
      
    public List<T> findByProperty(Class entityClass, String propertyName,Object value) {  
        String queryString = "from "+entityClass.getName()+ " as model where model." + propertyName + "=?";     
        return (List<T>) super.getHibernateTemplate().find(queryString, value);  
    }  
      
    //分页使用  
    public List<T> findByPage(Class<T> entityClass,int start,int limit) {  
          Query query=super.currentSession().createQuery("select o from "+entityClass.getName()+" o");  
          query.setFirstResult(start).setMaxResults(limit);  
        return query.list();  
    }  
      
    public T getTotalCount(Class entityClass) {  
        return (T)super.currentSession().createQuery("select count(o) from "+entityClass.getName()+" o").uniqueResult();  
    }  
  
    public T getPageCount(String hql, Object[] params) {  
        Query query = super.currentSession().createQuery(hql);//getSession().createQuery(hql);  
        if(null!= params && params.length>0){  
            for(int i = 0; i<params.length;i++){  
                query.setParameter(i, params[i]);  
            }  
        }  
        return (T)query.list();  
    }

	@Override
	public T get(PK id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T getWithLock(PK id, LockMode lock) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T load(PK id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T loadWithLock(PK id, LockMode lock) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(T entity) {
	//	super.getHibernateTemplate().update(entity) ;
		super.currentSession().update(entity) ;
//		super.getSessionFactory().openSession().update(entity) ;
	}


	@Override
	public void updateWithLock(T entity, LockMode lock) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteWithLock(T entity, LockMode lock) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteByKey(PK id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteByKeyWithLock(PK id, LockMode lock) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Collection<T> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int bulkUpdate(String queryString) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int bulkUpdate(String queryString, Object[] values) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List find(String sql) {
		return super.currentSession().createSQLQuery(sql).list() ;
	}


	@Override
	public List find(String queryString, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List findByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List findByNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List findByNamedQuery(String queryName, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterator iterate(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterator iterate(String queryString, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void closeIterator(Iterator it) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public DetachedCriteria createDetachedCriteria() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Criteria createCriteria() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List findByCriteria(DetachedCriteria criteria, int firstResult,
			int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> findEqualByEntity(T entity, String[] propertyNames) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> findLikeByEntity(T entity, String[] propertyNames) {
		return null;
	}


	@Override
	public Integer getRowCount(DetachedCriteria criteria) {
		return null;
	}


	@Override
	public Object getStatValue(DetachedCriteria criteria, String propertyName,
			String StatName) {
		return null;
	}


	@Override
	public void lock(T entity, LockMode lockMode) {
		
	}


	@Override
	public void initialize(Object proxy) {
		
	}


	@Override
	public void flush() {
		
	}  
  
}
