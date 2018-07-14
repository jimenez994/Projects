package com.zeus.LoginGF.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	@Column
	private String username;
	
	@Column
    @JsonIgnore
	private String password;
	
//	private Collection<GrantedAuthority> gratedAuthriesList = new ArrayList();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;
    
    public UserModel(UserModel user) {
    	this.id = user.getId();
    	this.username = user.getUsername();
    	this.password = user.getPassword();
    	this.roles = user.getRoles();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

//	public Collection<GrantedAuthority> getGratedAuthriesList() {
//		return gratedAuthriesList;
//	}
//
//	public void setGratedAuthriesList(Collection<GrantedAuthority> gratedAuthriesList) {
//		this.gratedAuthriesList = gratedAuthriesList;
//	}
	
	
	
	

}
