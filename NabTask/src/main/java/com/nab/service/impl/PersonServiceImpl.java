package com.nab.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nab.dao.entity.Person;
import com.nab.dao.repository.PersonRepository;
import com.nab.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	@Transactional
	public Person save(Person person) {
		return personRepository.saveAndFlush(person);
	}

	@Override
	@Transactional
	public boolean delete(Person person) {
		personRepository.delete(person);
		return true;
	}

	@Override
	@Transactional
	public Person update(Person person) {
		return personRepository.saveAndFlush(person);
	}

	@Override
	public Page<Person> findAll(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	@Override
	public Person find(Long id) {
		Optional<Person> p =  personRepository.findById(id);
		if(p.isPresent()) return p.get();
		return null;
	}

}
