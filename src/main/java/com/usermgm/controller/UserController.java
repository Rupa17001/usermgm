package com.usermgm.controller;

import java.util.List;

import javax.validation.Valid;

import com.usermgm.dto.UserDto;
import com.usermgm.exception.UserException;
import com.usermgm.model.User;
import com.usermgm.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService service;
	
	//add user to the table
	//only valid data enters the table (: validations used in UserDto)
	@PostMapping("/add")
	public ResponseEntity<User> addUser (@RequestBody @Valid UserDto u1){
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.OK);
	}
	//Getting details of all the user from table
	@GetMapping("/get")
	public ResponseEntity<List<User>> getUser(){
		return new ResponseEntity<>(service.getUser(),HttpStatus.ACCEPTED);
	}
	//fetching details of 1 user at a time using id
	@GetMapping("/get {id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserException{
		return new ResponseEntity<>(service.getUser(id),HttpStatus.ACCEPTED);
	}
	//Deletes the user data from table
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) throws UserException {
			
			return new ResponseEntity<>(service.deleteUser(id),HttpStatus.ACCEPTED);	
	}
	//updating the User Data in Table
	@PutMapping("/update{id}")
	public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto u1){
	
		return new ResponseEntity<>(service.updateUser(u1),HttpStatus.OK);
	}
}
