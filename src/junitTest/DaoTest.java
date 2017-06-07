package junitTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.whir.springmvc.dao.UserDao;
import com.whir.springmvc.dao.impl.UserDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
//∏ÊÀﬂjunit£¨spring≈‰÷√Œƒº˛
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class DaoTest {

	//@Autowired
	//private UserDao userDao  ;
	
	@Test
	public void testList(){
		/*List list = null ; 
		list = userDao.listAll() ;
		System.out.println(list==null);
		for(int i=0; list!=null && i<list.size() ;++i){
			System.out.println(list.get(i));
		}*/
		System.out.println("1111111111111");
	}
}
