package com.micro1service.user.service.service;

import java.util.List;

import com.micro1service.user.service.entity.User;
import com.micro1service.user.service.exceptionhandler.ResourceNotFoundException;

public interface UserService {

	public User save(User user);
	
	public List<User>gelAll();
	
	public User getByUserId(String id)throws ResourceNotFoundException;
	
	public User Update(String id, User user1)throws ResourceNotFoundException;
	
	public User Delete(String id)throws ResourceNotFoundException;
}
