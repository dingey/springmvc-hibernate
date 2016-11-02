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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
@Transactional
public class DaoTest {
	@Autowired
	PersonService personService;

	@Test
	public void test() {
		List<Person> ps = personService.findAll();
		for (Person p : ps) {
			System.out.println(p);
		}
	}
}
