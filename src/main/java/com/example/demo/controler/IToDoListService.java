package com.example.demo.controler;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.example.demo.endpoints.dto.ToDoListItemDTO;
import com.example.demo.endpoints.dto.UpdateToDoListItemDTO;

public interface IToDoListService {
	public List<String> getUserToDoList(String userName);

	public Map<HttpStatus, String> setUserItem(ToDoListItemDTO toDoListItemDto);

	public Map<HttpStatus, String> updateUserItem(UpdateToDoListItemDTO updateToDoListItemDTO);

	public Map<HttpStatus, String> deleteUserItem(ToDoListItemDTO toDoListItemDto);
}
