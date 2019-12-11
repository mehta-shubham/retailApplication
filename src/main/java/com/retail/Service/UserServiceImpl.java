package com.retail.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.Dao.UserDao;
import com.retail.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public Optional<User> getUser(Long id){
		return userDao.findById(id);
	}
	
	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}
}
