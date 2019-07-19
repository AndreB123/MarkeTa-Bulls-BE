package com.revature.service;


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
	
	public boolean isValidUser(HttpServletRequest req, HttpServletResponse resp) {
		final String username = req.getParameter("youremail");
		final String password = req.getParameter("password");
		System.out.println(username);
		
		if(username != null && !username.equals("") && password != null && !password.equals("")) {
			if(ur2.getUserByUsername(username) != null && password.equals(ur2.getUserByUsername(username).getPassword())) {
				HttpSession s = req.getSession();
				s.setAttribute("user's name", username);
				
				return true;
			}
		}
		return false;
	}
}
