package com.toufika.userservice.service;

import com.toufika.userservice.request.UserRequest;

public interface UserService {

	UserRequest createUser(UserRequest request);

	UserRequest findUser(Integer id);


}  
