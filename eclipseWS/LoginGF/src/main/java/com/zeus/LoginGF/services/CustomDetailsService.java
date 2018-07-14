package com.zeus.LoginGF.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zeus.LoginGF.models.CustomUser;
import com.zeus.LoginGF.models.UserModel;
import com.zeus.LoginGF.repositories.UserDAO;

@Service
public class CustomDetailsService implements UserDetailsService {
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userDAO.findByUsername(username);
		CustomUser customUser = new CustomUser(userModel);
		return customUser;
	}

}
