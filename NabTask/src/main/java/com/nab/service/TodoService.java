package com.nab.service;

import java.util.List;

import com.nab.dao.entity.Person;
import com.nab.dao.entity.Todo;

public interface TodoService {
	public Todo save(Person p , Todo todo);
	public List<Todo> findByPersonId(Long personId);
	public List<Todo> save(Person person , List<Todo> todos);
	public boolean delete(Person person , Todo todo);
}
