package com.nab.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.dao.repository.PersonRepository;
import com.nab.dao.repository.TodoRepository;
import com.nab.service.impl.TodoServiceImpl;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class TodoServiceTest {

	
	static class InjectTodoService{
		
		@Autowired
		private PersonRepository personRepository;
		
		@Autowired
		private TodoRepository todoRepository;
		
		@Bean
		public TodoService todoService() {
			return new TodoServiceImpl(personRepository, todoRepository);
		}
	}
	
	
	@Autowired
	private TodoService todoService;
	
//	
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void testSavePersonListOfTodo() {
//		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
//		fail("Not yet implemented");
	}

	@Test
	public void testFindByPersonId() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSavePersonTodo() {
//		fail("Not yet implemented");
	}

}
