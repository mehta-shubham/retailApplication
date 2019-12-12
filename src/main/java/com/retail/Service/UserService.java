package com.retail.service;

import java.util.Optional;

import com.retail.model.User;

public interface UserService {
	
	/**
	 * Fetches the user from database based on id provided.
	 * @param id
	 * @return
	 * @throws UserNotFooundException
	 */
	public Optional<User> getUser(Long id);
	
	/**
	 * Creates a new user
	 * @param user
	 * @return
	 * @throws UserCreationException
	 */
	public User addUser(User user);
}
