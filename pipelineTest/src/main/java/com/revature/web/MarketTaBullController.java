package com.revature.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface MarketTaBullController {
//	public User getUserByUsername(String username);
	public void isValidUser(HttpServletRequest req, HttpServletResponse resp);
}
