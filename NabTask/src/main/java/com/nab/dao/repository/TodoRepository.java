package com.nab.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nab.dao.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByPersonId(Long personId);
}
