package com.retail.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.retail.model.User;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
}
