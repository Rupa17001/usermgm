package com.usermgm.service;

import java.util.List;

import com.usermgm.dto.UserDto;
import com.usermgm.exception.UserException;
import com.usermgm.model.User;
import com.usermgm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	//add user 
	// transaction with table
	public User addUser(UserDto u1) {
		User u2 = User.build(u1.getUserId(), u1.getUserName(), u1.getUserPhone(), u1.getUserEmail(), u1.getUserPassword());
		return repo.save(u2);
	}
	// retrieving All the user's details
	public List<User> getUser(){
		return repo.findAll();
	}
	//retrieve info of specific User
	// using id
	public User getUser (int uId)throws UserException{
		User u1 = repo.findByUserId(uId);
		if(u1!=null) {
			return u1;
		}
		else {
			throw new UserException("User not Foundwith Id : "+uId);
			}
	}
	//deletes the user by feeding id
	public User deleteUser(int id) throws UserException  {
		
		User u2=repo.findByUserId(id);
		if(u2!=null) {
			repo.deleteById(id);
			return u2;
		}
		else {
			throw new UserException("user not found!...");
		}
		
	}
	//updating the data of the specific User
	public User updateUser(UserDto u1) {
		
		User u2=User.build(u1.getUserId(), u1.getUserName(), u1.getUserPhone(), u1.getUserEmail(),u1.getUserPassword());
		return repo.save(u2);
	}
	
	
}
