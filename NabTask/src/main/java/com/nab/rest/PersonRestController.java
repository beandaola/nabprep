package com.nab.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nab.dao.entity.Person;
import com.nab.service.PersonService;

@RestController
@RequestMapping("user")
public class PersonRestController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public Person save(@RequestBody Person person) {
		
		return personService.save(person);
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public Person get(@PathVariable("id") Long id) {	
		return  personService.find(id);
	}
}
