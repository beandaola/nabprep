package com.nab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nab.dao.entity.Person;

public interface PersonService {
	public Person find(Long id);
	public Page<Person> findAll(Pageable pageable);
	public Person save(Person person);
	public boolean delete(Person person);
	public Person update(Person person);
}
