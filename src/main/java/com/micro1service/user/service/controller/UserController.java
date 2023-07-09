package com.micro1service.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro1service.user.service.entity.User;
import com.micro1service.user.service.exceptionhandler.ResourceNotFoundException;
import com.micro1service.user.service.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private final UserService userService;

	public UserController(UserService userSer) {
		this.userService = userSer;
	}

	@PostMapping("/post")
	public ResponseEntity<User> SaveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable String id) throws ResourceNotFoundException {
		return new ResponseEntity<User>(userService.getByUserId(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok().body(userService.gelAll());
	}

	@PutMapping("update/{id}")
	public ResponseEntity<User> Update(@PathVariable String id, @RequestBody User user1)
			throws ResourceNotFoundException {
		return new ResponseEntity<User>(userService.Update(id, user1), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<User> Delete(@PathVariable String id) throws ResourceNotFoundException {
		return new ResponseEntity<User>(userService.Delete(id), HttpStatus.OK);
	}

}
