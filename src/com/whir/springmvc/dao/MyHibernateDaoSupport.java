package com.whir.springmvc.dao;

import javax.annotation.Resource;  
import org.hibernate.SessionFactory;  
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;  
  
/** 
 * ����֮����Ҫ��д 
 * HibernateDaoSupport��������Ϊ������ҪΪDAO�����ע��SessionFactory������ԡ� 
 * �Ժ����ǿ�����DAO�࣬�Ϳ���ֱ���������MyHibernateDaoSupport�ˡ� 
 * ��ʵ�����������൱�������ļ���ʽ�Ĵ��룺 
 * <bean id="userDao" class="com.oa.dao.UserDaoImpl">  
 * <property name="sessionFactory" ref="sessionFactory"/>  
 * </bean> 
 *  
 * @author huangdb 
 *  
 */  
public class MyHibernateDaoSupport extends HibernateDaoSupport {  
      
    @Resource(name="sessionFactory")    //Ϊ����HibernateDaoSupportע��sessionFactory��ֵ  
    public void setSuperSessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    }  
      
  
}  