package com.revature.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	public User isValidUser(String username, String password) {

		System.out.println(username);
		System.out.println(password);
		
<<<<<<< HEAD
		if(Username != null && !Username.equals("") && password != null && !password.equals("")) {
			if(ur2.getUserByUsername(Username) != null && password.equals(ur2.getUserByUsername(Username).getPassword())) {
				System.out.println(Username);
				return ur2.getUserByUsername(Username);
=======
		if(username != null && !username.equals("") && password != null && !password.equals("")) {
			if(ur2.getUserByUsername(username) != null && password.equals(ur2.getUserByUsername(username).getPassword())) {
				
				return ur2.getUserByUsername(username);
>>>>>>> 4be4cfa7c993994aca06ac0f73df2bad88084d92
			}
		}
		return null;
	}

	@Override
	public void newUser(String username, String password, double balance) {		
		ur2.newUser(username, password, balance);
		return;
	}

	@Override
	public User getAllUsers(String username, String password) {		
		return ur2.getAllUsers(username, password);
		
	}

	@Override
	public void updateBalance(String username, double balance) {
		// TODO Auto-generated method stub
		
	}
}
