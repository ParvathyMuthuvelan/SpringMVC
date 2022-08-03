package com.dao;

import java.util.List;

import com.model.User;

public interface LoginDao {
	public List<User> fetchUsers() ;

	public boolean validateUser(User user);
}
