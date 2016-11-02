package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.di.entity.Person;
import com.di.service.PersonService;
import com.di.toolkit.JacksonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
@Transactional
public class DaoTest {
	@Autowired
	PersonService personService;

	@Test
	public void test() {
		list();
	}

	public void list() {
		String sql = "select t1.user_id as userId,t1.user_name as userName from `user` t1,role_user t2,role t3 where t1.user_id=t2.user_id and t2.role_id=t3.role_id";
		List<User> us = personService.findByNativeQuery(sql, User.class, null, null);
		for (User u : us) {
			System.out.println(JacksonUtil.pojoToJson(u));
		}
	}

	public void count() {
		System.out.println(personService.findUniqueResultByNativeQuery("select count(0) from person"));
	}

	public void nativeQuery() {
		List<Person> ps = personService.findByNativeQuery("select * from person where id>2");
		for (Person p : ps) {
			System.out.println(p);
		}
	}

	public void findAll() {
		List<Person> ps = personService.findAll();
		for (Person p : ps) {
			System.out.println(p);
		}
	}
}
