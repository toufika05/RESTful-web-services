package com.toufika.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toufika.userservice.request.UserRequest;

@Repository
public interface UserRepository extends JpaRepository<UserRequest, Integer>{

}
