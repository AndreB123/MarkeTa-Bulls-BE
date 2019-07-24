package com.revature.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.User;


public interface MarketTaBullController {
//	public User getUserByUsername(String username);
	public String isValidUser(String username, String Password);
	public void createUser(HttpServletRequest req, HttpServletResponse resp);
}
