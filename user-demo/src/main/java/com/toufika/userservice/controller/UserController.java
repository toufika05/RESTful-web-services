package com.toufika.userservice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toufika.userservice.exception.UserNotFoundException;
import com.toufika.userservice.request.UserRequest;
import com.toufika.userservice.response.UserResponse;
import com.toufika.userservice.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){
		UserRequest createUser= userservice.createUser(request);
		UserResponse response=new UserResponse();
		if(createUser != null){
			response.setError(false);
			response.setMessage("user created successfully");
			response.setLists(Arrays.asList(createUser));
		}
		return ResponseEntity.ok(response);
		//return new ResponseEntity<UserResponse>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable("id") Integer id){
		UserRequest findUser =userservice.findUser(id);
		
		if( findUser == null) {
			 throw new UserNotFoundException("user not found");
		}
		UserResponse response=new UserResponse();
		response.setError(false);
		response.setMessage("user Found Successfully");
		response.setLists(Arrays.asList(findUser));
		return ResponseEntity.ok(response);
		
		/*
		System.out.println(findUser.getName());
		UserResponse response=new UserResponse();
		if(findUser !=null) {
			response.setError(false);
			response.setMessage("user Found Successfully");
			response.setLists(Arrays.asList(findUser));
			return ResponseEntity.ok(response);
		}else {
			response.setError(true); 
			response.setMessage("user Not Found");
			return new ResponseEntity<UserResponse>(response, HttpStatus.NOT_FOUND);
		}
		*/
	}
	
}
