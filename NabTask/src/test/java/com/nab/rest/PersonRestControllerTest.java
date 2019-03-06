package com.nab.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nab.dao.entity.Person;
import com.nab.service.PersonService;



@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
@ActiveProfiles("test")
public class PersonRestControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PersonService personService; 

	@Autowired 
	private ObjectMapper objectMapper;
	private JacksonTester<Person> json;
	
	@Before
	public void setup() {
		JacksonTester.initFields(this, objectMapper);

	}
	
	@Test
	public void testSavePerson() throws Exception{
		Person p = new Person();
		p.setName("test1");;
		p.setClient("client1");
		when(personService.save(p)).thenReturn(p);
		mvc.perform(post("http://localhost:8080/user")
				.contentType(MediaType.APPLICATION_JSON).content(json.write(p).getJson()))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value(equalTo("test1")));
	}
	
	
	
	@Test
	public void testGetPerson() throws Exception {
		Person p = new Person();
		p.setName("test1");;
		p.setClient("client1");
		p.setId(1L);
		when(personService.find(1L)).thenReturn(p);
		mvc.perform(get("http://localhost:8080/user/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").isNumber());
		
	}

}
