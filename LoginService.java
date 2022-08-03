package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;
import com.model.User;

@Service
public class LoginService {

	@Autowired
	LoginDao loginDao;


	
	public boolean validateUser(User user) {
		boolean result = false;
		result=loginDao.validateUser(user);
		
		return result;
	}

	public List<User> fetchUsers() {
		List<User> usrList = loginDao.fetchUsers();

		return usrList;
	}
}
