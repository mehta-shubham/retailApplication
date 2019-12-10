package com.retail.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.Dao.UserDao;
import com.retail.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public Iterable<User> getAllUsers(){
		return userDao.findAll();
	}
	
	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}
}
