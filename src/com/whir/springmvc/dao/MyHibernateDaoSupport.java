package com.whir.springmvc.dao;

import javax.annotation.Resource;  
import org.hibernate.SessionFactory;  
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;  
  
/** 
 * 我们之所以要改写 
 * HibernateDaoSupport，是因我为，我们要为DAO层的类注入SessionFactory这个属性。 
 * 以后，我们开发的DAO类，就可以直接重用这个MyHibernateDaoSupport了。 
 * 其实，这样做是相当于配置文件方式的代码： 
 * <bean id="userDao" class="com.oa.dao.UserDaoImpl">  
 * <property name="sessionFactory" ref="sessionFactory"/>  
 * </bean> 
 *  
 * @author huangdb 
 *  
 */  
public class MyHibernateDaoSupport extends HibernateDaoSupport {  
      
    @Resource(name="sessionFactory")    //为父类HibernateDaoSupport注入sessionFactory的值  
    public void setSuperSessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    }  
      
  
}  