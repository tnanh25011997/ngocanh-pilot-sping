package com.magrabbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magrabbit.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String> {

}
