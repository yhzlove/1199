package com.y.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.y.entity.User;
import com.y.service.UserServiceI;
import com.y.util.Common;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private UserServiceI userService;
	@Autowired(required=true)
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping("index")
	public String index(){
		
		return "login";
	}
	
	@RequestMapping("login")
	public String login(User entity, Model model, HttpServletRequest request){
		
//		if (Common.isEmpty(username) || Common.isEmpty(password)) {
//			request.setAttribute("error", "用户名或密码不能为空！");
//			return "/login";
//		}
		System.out.println(entity.getLoginName());
		System.out.println(entity.getPassword());
		
		
		return "login";
	}
	
}
