package com.retail.Service;

import java.util.Optional;

import com.retail.model.User;

public interface UserService {
	public Optional<User> getUser(Long id);
	public User addUser(User user);
}
