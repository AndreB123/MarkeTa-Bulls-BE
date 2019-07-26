package com.revature.service;

import com.revature.model.User;

/*
 * The UserService listing the methods that will be implemented in the 
 * UserServiceImpl. 
 */

public interface UserService {
	
	public User getUserByUsername(String username);

	public User isValidUser(String username, String password);
	//User getAllUsers(HttpServletRequest req, HttpServletResponse resp);
	//void newUser(String username, String password);

	void newUser(String username, String password, double balance);

	User getAllUsers(String username, String password);
}
