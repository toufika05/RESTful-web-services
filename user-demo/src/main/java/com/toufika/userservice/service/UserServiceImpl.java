package com.toufika.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toufika.userservice.repository.UserRepository;
import com.toufika.userservice.request.UserRequest;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserRequest createUser(UserRequest request) {
		
		return repo.save(request);
	}

	@Override
	public UserRequest findUser(Integer id) {
		return repo.findById(id).orElse(null);
	}


  
}
