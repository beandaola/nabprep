package com.nab.repository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.dao.entity.Person;
import com.nab.dao.repository.PersonRepository;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

//	@Autowired
//    private TestEntityManager testEntityManager;

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void testSave() {
		Person p = new Person();
		p.setName("Brian");
		p.setClient("NAB");
		p = personRepository.saveAndFlush(p);
		assertThat(p.getId()).isNotNull();
	}

}
