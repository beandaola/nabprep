package com.nab.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.dao.entity.Person;
import com.nab.dao.entity.Todo;
import com.nab.dao.repository.PersonRepository;
import com.nab.dao.repository.TodoRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class TodoRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Test
	public void testFindByPersonId() {
		Person p = new Person();
		p.setName("test1");
		p.setClient("client1");
		p = personRepository.saveAndFlush(p);
		
		Todo todo = new Todo();
		todo.setSummary("todo1");
		todo.setDescription("todo1 description");
		todo.setPerson(p);
		
		todo = todoRepository.saveAndFlush(todo);
		
		
		List<Todo> todos = todoRepository.findByPersonId(p.getId());
		
		assertThat(todos.size()).isEqualTo(1);
	}
	
}
