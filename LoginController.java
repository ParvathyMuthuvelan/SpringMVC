package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.model.User;

@Controller
public class LoginController {
	@RequestMapping(value="/showLogin",method=RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mview = new ModelAndView("login");
		mview.addObject("user", new User());

		return mview;
	}
	
	@RequestMapping(value="/loginValidate",method=RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute("user") User user) {
	
		ModelAndView mav = null;

		
		if (user.getUsername().equals("admin") && user.getPassword().equals("admin@123")) {
			mav = new ModelAndView("welcome");
			String username = user.getUsername();
			System.out.println("name "+username);
			mav.addObject("uname", username);

		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}

		return mav;
	}

}
