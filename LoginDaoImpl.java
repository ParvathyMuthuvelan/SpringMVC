package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class LoginDaoImpl implements LoginDao{
	public List<User> fetchUsers() {
		List<User> usrList = new ArrayList<>();
		User usr = new User();
		usr.setUsername("Sai");
		usrList.add(usr);
		usr=new User();
		usr.setUsername("Sri");
		usrList.add(usr);
		usr=new User();
		usr.setUsername("Minu");
		usrList.add(usr);
		return usrList;
	}
	
	@Override
	public boolean validateUser(User user) {
		boolean result=false;
		if (user.getUsername().equals("admin") && user.getPassword().equals("admin@123")) {
			result = true;
		}
		return result;
	}
}
