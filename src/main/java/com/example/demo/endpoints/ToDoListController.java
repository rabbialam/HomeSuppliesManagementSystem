package com.example.demo.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controler.ToDoListService;
import com.example.demo.endpoints.dto.ToDoListItemDTO;
import com.example.demo.endpoints.dto.UpdateToDoListItemDTO;

@RestController
public class ToDoListController {

	@Autowired
	ToDoListService toDoListService;

	@PostMapping("/addItem")
	public Map<HttpStatus, String> addItem(@RequestBody ToDoListItemDTO toDoListItemDTO) {
		return toDoListService.setUserItem(toDoListItemDTO);
	}

	@GetMapping("/getItems")
	public Map<HttpStatus, List<String>> getItems(@RequestParam String userName) {
		Map<HttpStatus, List<String>> httpStatus = new HashMap<>();
		List<String> userToDoList = new ArrayList<>();
		if (userName != null && !userName.isEmpty()) {
			userToDoList = toDoListService.getUserToDoList(userName);
			if (userToDoList == null || userToDoList.isEmpty()) {
				List<String> errorString = new ArrayList<>();
				errorString.add("No list found for user");
				httpStatus.put(HttpStatus.BAD_REQUEST, errorString);
			} else {
				httpStatus.put(HttpStatus.OK, userToDoList);
			}
		} else {
			List<String> errorString = new ArrayList<>();
			errorString.add("No user specified");
			httpStatus.put(HttpStatus.BAD_REQUEST, errorString);
		}

		return httpStatus;
	}

	@PutMapping("/updateItem")
	public Map<HttpStatus, String> updateItem(@RequestBody UpdateToDoListItemDTO updateToDoListItemDTO) {
		return toDoListService.updateUserItem(updateToDoListItemDTO);
	}

	@PostMapping("/deleteItem")
	public Map<HttpStatus, String> deleteItem(@RequestBody ToDoListItemDTO toDoListItemDTO) {
		return toDoListService.deleteUserItem(toDoListItemDTO);
	}

}
