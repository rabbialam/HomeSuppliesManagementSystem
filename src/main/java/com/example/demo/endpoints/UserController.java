package com.example.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controler.UserService;
import com.example.demo.endpoints.dto.UserDTO;

@RestController

public class UserController {

	@Autowired
	UserService userService;
	@GetMapping("/user")
	public UserDTO getUser(@RequestParam String userName) {
		return userService.getUser(userName);
	}
}
