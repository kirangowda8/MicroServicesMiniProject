package com.micro1service.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.micro1service.user.service.entity.User;
import com.micro1service.user.service.exceptionhandler.ResourceNotFoundException;
import com.micro1service.user.service.repository.UserRepository;
import com.micro1service.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepo) {
		this.userRepository = userRepo;
	}

	@Override
	public User save(User user) {
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);

	}

	@Override
	public List<User> gelAll() {
		return userRepository.findAll();
	}

	@Override
	public User getByUserId(String id) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found", HttpStatus.NOT_FOUND));
		return user;
	}

	@Override
	public User Update(String id, User user1) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found", HttpStatus.NOT_FOUND));
		user.setName(user1.getName());
		user.setEmail(user1.getEmail());
		user.setAbout(user1.getAbout());
		userRepository.save(user);
		return user;
	}

	@Override
	public User Delete(String id) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found", HttpStatus.NOT_FOUND));
		return user;
	}

}
