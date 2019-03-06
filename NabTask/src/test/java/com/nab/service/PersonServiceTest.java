package com.nab.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.dao.entity.Person;
import com.nab.dao.repository.PersonRepository;
import com.nab.service.impl.PersonServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class PersonServiceTest {

	
	@TestConfiguration
	static class InjectPersonService{
		
		@Autowired
		private PersonRepository personRepository;
		
		@Bean
		public PersonService personService() {
			return new PersonServiceImpl(personRepository);
		}
	}
	
	@Autowired
	private PersonService personService;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		Person p = new Person();
		p.setName("test1");
		p.setClient("NAB");
		p = personService.save(p);
		assertThat(p.getId()).isNotNull();
	}

	@Test
	public void testDelete() {
		Person p = new Person();
		p.setName("test1");
		p.setClient("NAB");
		p = personService.save(p);
		assertThat(p.getId()).isNotNull();
		boolean deleted = personService.delete(p);
		assertThat(deleted).isTrue();
	}

	@Test
	public void testUpdate() {
		Person p = new Person();
		p.setName("test1");
		p.setClient("NAB");
		p = personService.save(p);
		assertThat(p.getId()).isNotNull();
		p.setClient("EA");
		p = personService.update(p);
		assertThat(p).hasFieldOrPropertyWithValue("client", "EA");
	}

	@Test
	public void testFindAll() {
		createPerson(14);
		Page<Person> page = personService.findAll(PageRequest.of(0, 5));
		assertThat(page.getTotalElements()).isEqualTo(14);
		assertThat(page.getNumber()).isEqualTo(0);
		
		page = personService.findAll(PageRequest.of(1, 5));

		assertThat(page.getNumber()).isEqualTo(1);
		
		page = personService.findAll(PageRequest.of(2, 5));
		assertThat(page.getNumber()).isEqualTo(2);
		assertThat(page.getNumberOfElements()).isEqualTo(4);
		
	}
	
	
	private void createPerson(int no) {
		for(int i = 1; i <= no ; i++) {
			Person p = new Person();
			p.setName("test" + i);
			p.setClient("NAB");
			p = personService.save(p);
		}
	}

}
