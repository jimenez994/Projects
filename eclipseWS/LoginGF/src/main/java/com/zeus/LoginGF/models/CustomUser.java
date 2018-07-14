package com.zeus.LoginGF.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User{

	private static final long serialVersionUID = 1L;

	public CustomUser(UserModel user) {
		super(user.getUsername(), user.getPassword(), (Collection<? extends GrantedAuthority>) user.getRoles());
	}
}
