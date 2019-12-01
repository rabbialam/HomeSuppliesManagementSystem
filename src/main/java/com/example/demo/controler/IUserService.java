package com.example.demo.controler;

import com.example.demo.endpoints.dto.UserDTO;

public interface IUserService {


	public UserDTO getUser(String userName) throws Exception;
}
