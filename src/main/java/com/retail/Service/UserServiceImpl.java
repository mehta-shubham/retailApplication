package com.retail.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.model.User;
import com.retail.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userDao;
	
	@Override
	public Optional<User> getUser(Long id){
		return userDao.findById(id);
	}
	
	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}
}
