package com.blog.services;

import java.util.List;

import com.blog.payloads.UserDto;

public interface UserService {
	
	UserDto registerNewUser(UserDto userDto);
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto , Integer id);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer userId);

}
