package com.nab.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nab.dao.entity.Person;
import com.nab.dao.entity.Todo;
import com.nab.dao.repository.PersonRepository;
import com.nab.dao.repository.TodoRepository;
import com.nab.service.TodoService;

@Service("todoService")
public class TodoServiceImpl implements TodoService {

	private PersonRepository personRepository;
	private TodoRepository todoRepository;
	
	@Autowired
	public TodoServiceImpl(PersonRepository personRepository ,TodoRepository todoRepository) {
		this.personRepository = personRepository;
		this.todoRepository = todoRepository;
	}
	
	@Override
	@Transactional
	public List<Todo> save(Person person, List<Todo> todos) {
		if(!isValidPerson(person)) return Collections.emptyList();
		Optional<Person> p = personRepository.findById(person.getId());
		if(p.isPresent()) {
			person = p.get();
			for(Todo todo : todos) {
				todo.setPerson(person);
			}
			personRepository.saveAndFlush(person);
		}
		
		return findByPersonId(person.getId());
	}

	@Override
	@Transactional
	public boolean delete(Person person, Todo todo) {
		if(!isTodoExisted(todo)) return false;
		todoRepository.delete(todo);
		return true;
	}

	@Override
	public List<Todo> findByPersonId(Long personId) {
		return todoRepository.findByPersonId(personId);
	}

	private boolean isValidPerson(Person person) {
		if(person == null || person.getId() == null || person.getId().longValue() < 0) return false;
		return personRepository.existsById(person.getId());
	}
	
	private boolean isTodoExisted(Todo todo) {
		if(todo == null || todo.getId() == null || todo.getId().longValue() <0) return false;
		return todoRepository.existsById(todo.getId());
	}

	@Override
	@Transactional
	public Todo save(Person p, Todo todo) {
		todo.setPerson(p);
		return todoRepository.saveAndFlush(todo);
	}
}
