package com.toufika.userservice.response;

import java.util.List;

import com.toufika.userservice.request.UserRequest;

import lombok.Data;

@Data
public class UserResponse {

	private boolean error;
	private String message;
	private List<UserRequest> lists;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UserRequest> getLists() {
		return lists;
	}
	public void setLists(List<UserRequest> lists) {
		this.lists = lists;
	}
	
	
}
