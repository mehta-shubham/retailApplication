package com.retail.Service;

import com.retail.model.User;

public interface UserService {
	public Iterable<User> getAllUsers();
	public User addUser(User user);
}
