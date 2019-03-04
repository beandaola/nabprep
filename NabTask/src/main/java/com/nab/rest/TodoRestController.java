package com.nab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nab.dao.entity.Person;
import com.nab.dao.entity.Todo;
import com.nab.service.PersonService;
import com.nab.service.TodoService;

@RestController
@RequestMapping("todo")
public class TodoRestController {
	
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TodoService todoService;
	
	
	@PostMapping(path="{personId}")
	public Todo save(@PathVariable("personId")Long personId,  @RequestBody Todo todo) {
		Person p = personService.find(personId);
		return todoService.save(p, todo);
	}
	
	@GetMapping("/person/{personId}")
	public List<Todo> getAllByPersionId(@PathVariable("personId")Long personId){
		return todoService.findByPersonId(personId);
	}
	
}
