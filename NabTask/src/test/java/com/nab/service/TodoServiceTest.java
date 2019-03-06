package com.nab.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.dao.entity.Person;
import com.nab.dao.entity.Todo;
import com.nab.dao.repository.PersonRepository;
import com.nab.dao.repository.TodoRepository;
import com.nab.service.impl.PersonServiceImpl;
import com.nab.service.impl.TodoServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class TodoServiceTest {

	@TestConfiguration
	static class InjectTodoService{
		
		@Autowired
		private PersonRepository personRepository;
		
		@Autowired
		private TodoRepository todoRepository;
		
		@Bean
		public TodoService todoService() {
			return new TodoServiceImpl(personRepository, todoRepository);
		}
		
		@Bean
		public PersonService personService() {
			return new PersonServiceImpl(personRepository);
		}
		
	}
	
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private PersonService personService;
	

	@Test
	public void testSavePersonListOfTodo() {
		Person p = new Person();
		p.setName("test1");
		p.setClient("NAB");
		p = personService.save(p);
		
		List<Todo> todos = createTodo(3);
		todos = todoService.save(p, todos);
		assertThat(todos).allMatch((t)-> t.getId()!=null);
		
		
	}
	
	@Test
	public void testDelete() {
		Person p = new Person();
		p.setName("test1");
		p.setClient("NAB");
		p = personService.save(p);
		List<Todo> todos = createTodo(3);
		todos = todoService.save(p, todos);
		assertThat(todos.size()).isEqualTo(3);
		boolean deleted = todoService.delete(p, todos.get(0));
		assertThat(deleted).isTrue();
		todos = todoService.findByPersonId(p.getId());
		assertThat(todos.size()).isEqualTo(2);
		
	}

	@Test
	public void testFindByPersonId() {
		Person p = new Person();
		p.setName("test1");
		p.setClient("NAB");
		p = personService.save(p);
		List<Todo> todos = createTodo(3);
		todos = todoService.save(p, todos);
		todos = todoService.findByPersonId(p.getId());
		assertThat(todos.size()).isEqualTo(3);
	}

	@Test
	public void testSavePersonTodo() {
		Person p = new Person();
		p.setName("test1");
		p.setClient("NAB");
		p = personService.save(p);
		List<Todo> todos = createTodo(1);
		Todo todo = todoService.save(p, todos.get(0));
		assertThat(todo.getId()).isNotNull();

	}

	private List<Todo> createTodo(int no){
		List<Todo> list = new ArrayList<>();
		for(int i = 1 ; i <= no ; i++) {
			Todo todo = new Todo();
			todo.setSummary("tod" + i);
			todo.setDescription("summary" +1);
			list.add(todo);
		}
		return list;
	}
}
