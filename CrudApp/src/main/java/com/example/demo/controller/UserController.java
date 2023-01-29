package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.UserDB;
import com.example.demo.DAO.UserDAO;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userdao;
	
	@RequestMapping("index")
	public String index(UserDB user) {
		return "index.jsp";
	}
	
	@RequestMapping("addUser")
	public String addUser(UserDB user) {
		userdao.save(user);
		return "index.jsp";
	}
	
	@RequestMapping("getUser")
	public  ModelAndView getUser(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();

		UserDB user=userdao.findById(id).orElse(null);
		
		mav.setViewName("display.jsp");
		mav.addObject("user",user);
		
		return mav;
	}
	
	@RequestMapping("deleteUser")
	public  ModelAndView deleteUser(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();

		UserDB user=userdao.findById(id).orElse(null);
		userdao.deleteById(id);
		
		mav.setViewName("delete.jsp");
		mav.addObject("user",user);
		
		return mav;
	}
	
	@RequestMapping("updateUser")
	public  ModelAndView updateUser(UserDB user) {
		ModelAndView mav = new ModelAndView("update.jsp");

		user=userdao.findById(user.getId()).orElse(null);
		userdao.deleteById(user.getId());
		
		mav.addObject("user",user);
		
		return mav;
	}

}
