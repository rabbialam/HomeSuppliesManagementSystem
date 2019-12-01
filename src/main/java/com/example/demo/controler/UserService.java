package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.endpoints.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Configuration
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO getUser(String userName) {
		User user = new User();
		UserDTO userDTO = new UserDTO();
		if(userName!=null && !userName.isEmpty()) {
			user = userRepository.findByUserName(userName);
			if(user!=null) {
				userDTO.setUserId(user.getUserId());
				userDTO.setUserName(user.getUserName());
			}
			else {
				userDTO.setException("User not found");
			}
		}
		else {
			userDTO.setException("Username not specified");
		}
		
		return userDTO;
	}

}
