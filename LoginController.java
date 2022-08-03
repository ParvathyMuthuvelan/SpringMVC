package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/showLogin",method=RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mview = new ModelAndView("login");
		mview.addObject("user", new User());

		return mview;
	}
	
	@RequestMapping(value="/loginValidate",method=RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute("user") User user) {
	
		ModelAndView mav = null;

		if(loginService.validateUser(user))
		{
	///	if (user.getUsername().equals("admin") && user.getPassword().equals("admin@123")) {
			mav = new ModelAndView("welcome");
			String username = user.getUsername();
			mav.addObject("uname", username);

		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}

		return mav;
	}
	@RequestMapping(value="/listUsers",method=RequestMethod.GET)
	public String fetchUsers(ModelMap map)
	{
		List<User> usrList=loginService.fetchUsers();
		map.addAttribute("users", usrList);
		return "listUsers";
		
	}

}
