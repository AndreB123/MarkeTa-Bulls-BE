package com.revature.service;

import java.util.List;

import com.revature.model.User;
import com.revature.repository.UserRepository;

public interface UserService {
	public List<User> getAllUsers();
}
