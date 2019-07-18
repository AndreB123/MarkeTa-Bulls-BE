package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

@Service("us")
public class UserServiceImpl implements UserService{

	private UserRepository ur;
	
	@Autowired
	public UserServiceImpl(UserRepositoryImpl ur) {this.ur = ur;}
	
	public void setUr(UserRepository ur) {
		this.ur = ur;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return ur.getAllUsers();
	}
}
