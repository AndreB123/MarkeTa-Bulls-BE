package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

@Service("us")
public class UserServiceImpl implements UserService{

	private UserRepository ur2;
	
	@Autowired
	public UserServiceImpl(UserRepositoryImpl ur) {this.ur2 = ur;}
	
	public void setUr(UserRepository ur) {
		this.ur2 = ur2;
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return ur2.getUserByUsername(username);
	}
}
