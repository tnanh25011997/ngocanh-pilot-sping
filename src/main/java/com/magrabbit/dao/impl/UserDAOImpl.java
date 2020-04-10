package com.magrabbit.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.magrabbit.dao.IUserDAO;

import com.magrabbit.entity.User;
import com.magrabbit.repository.UserRepository;

@Repository("userDao")
@Transactional
public class UserDAOImpl implements IUserDAO {
	
	@Autowired
	private UserRepository userRepository;
	public Optional<User> findByUsername(String username) {
		return userRepository.findById(username);
	}

}
