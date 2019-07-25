package com.revature.repository;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository("ur")
public interface UserRepository {
	User getUserByUsername(String username);
	void newUser(String username, String password, double balance);
	public User getAllUsers(String username, String password);
}
