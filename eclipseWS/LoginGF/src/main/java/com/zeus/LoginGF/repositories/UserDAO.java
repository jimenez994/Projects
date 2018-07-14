package com.zeus.LoginGF.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.LoginGF.models.UserModel;

@Repository
public interface UserDAO extends CrudRepository<UserModel, Long> {
	UserModel findByUsername(String username);
}
