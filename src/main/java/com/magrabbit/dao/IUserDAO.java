package com.magrabbit.dao;

import java.util.Optional;

import com.magrabbit.entity.User;

public interface IUserDAO {
	Optional<User> findByUsername(String username);
}
