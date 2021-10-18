package com.appsdevolperblog.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdevolperblog.app.ws.service.UserService;
import com.appsdevolperblog.app.ws.shared.dto.UserDto;
import com.appsdevolperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdevolperblog.app.ws.ui.model.response.UserRest;

@RestController // set as controller
@RequestMapping("users") // pre setting last part of url - http://localhsot:8080/users
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping // for http get methods
	public String getUser() {
		
		return "get user was calles";
	}
	@PostMapping // for http POST method
	public String createUser(@RequestBody UserDetailsRequestModel userDetails) {//to convert   json got from http request to java object
		
		UserRest returnValue = UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue; 
		
		
		
		return null;
	}
	
	@PutMapping //for PUT method
	public String updateUser() {
		return "update user was called";
				
	}
	@DeleteMapping // for DELETE method
	public String deleteUser() {
		
		return "delete user was called";
	}

}
