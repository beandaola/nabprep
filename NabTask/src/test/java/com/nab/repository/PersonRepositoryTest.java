package com.nab.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.dao.entity.Person;
import com.nab.dao.repository.PersonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class PersonRepositoryTest {

	@Autowired
    private TestEntityManager testEntityManager;

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
