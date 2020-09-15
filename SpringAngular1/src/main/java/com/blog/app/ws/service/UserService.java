package com.blog.app.ws.service;

import com.blog.app.ws.shared.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto getUser(String email);
	UserDto getUserByUserId(String userId);
}
