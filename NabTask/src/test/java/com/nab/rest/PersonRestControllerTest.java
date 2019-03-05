package com.nab.rest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.nab.service.PersonService;
@RunWith(SpringRunner.class)
@WebMvcTest
public class PersonRestControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PersonService personService; 

	@Test
	public void testGetPerson() {
		fail("Not yet implemented");
	}

}
