package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.ToDoListItem;

public interface ToDoListRepository extends CrudRepository<ToDoListItem, Long> {
	
	@Query("select t.itemDescription from ToDoListItem t where t.user.userId= ?1")
	public List<String> findByUserId(Long userId);
	
	@Query("select t from ToDoListItem t where t.user.userId= ?1 and t.itemDescription= ?2")
	public ToDoListItem findByUserIdAndItemDescription(Long userId,String itemDescription);
}
