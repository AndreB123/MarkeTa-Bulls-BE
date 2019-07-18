package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository(value="ur")
public class UserRepositoryImpl implements UserRepository{

	@Override
	public List<User> getAllUsers() {
		return null;
	}

}
