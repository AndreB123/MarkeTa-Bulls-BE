package com.revature.repository;

import org.springframework.stereotype.Repository;

import com.revature.model.User;

/*The UserRepository listing the methods that will be implemented in the 
* UserRepositoryImpl. 
*/

@Repository("ur")
public interface UserRepository {
	User getUserByUsername(String username);
	void newUser(String username, String password, double balance);
	public User getAllUsers(String username, String password);
	
}
