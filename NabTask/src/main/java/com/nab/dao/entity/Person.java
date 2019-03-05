package com.nab.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name="person")
@Data
@EqualsAndHashCode(of= {"id"})
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	
	@Column(name="client")
	private String client;
	
	@JsonIgnore
	@OneToMany(mappedBy="person", cascade=CascadeType.ALL)
	private List<Todo> todos;
}
