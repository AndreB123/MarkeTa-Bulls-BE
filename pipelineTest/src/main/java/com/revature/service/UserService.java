package com.revature.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.User;

public interface UserService {
	public User getUserByUsername(String username);
	public boolean isValidUser(HttpServletRequest req, HttpServletResponse resp);
}
