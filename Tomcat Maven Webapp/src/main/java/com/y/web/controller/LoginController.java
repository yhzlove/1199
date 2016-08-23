package com.y.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	/**
	 * 
	 * <P>跳转到登入页面</P>
	 * 2016年8月23日 上午10:57:09
	 * @author yanhz
	 */
	@RequestMapping("index")
	public String index(){
		
		return "login";
	}
	@RequestMapping("register")
	public String register(){
		
		return "register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	/**
	 * 
	 * <P>登入</P>
	 * 2016年8月23日 上午10:57:51
	 * @author yanhz
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User entity, Model model, HttpServletRequest request){
		
//		if (Common.isEmpty(username) || Common.isEmpty(password)) {
//			request.setAttribute("error", "用户名或密码不能为空！");
//			return "/login";
//		}
		System.out.println(entity.getLoginName());
		System.out.println(entity.getPassword());
		
		
		return "index";
	}
	
}
