package com.y.web.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import sun.util.logging.resources.logging;

import com.y.entity.User;
import com.y.service.UserServiceI;


@Controller
@RequestMapping("/user/")
public class UserController{
	
	private  static  final Logger logger = Logger.getLogger(UserController.class);
	
	private UserServiceI userService;
	@Autowired(required=true)
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		List<User> lstUsers = userService.getAllUser();
		model.addAttribute("lstUsers", lstUsers);
		logger.debug("List-----------");
		logger.debug("List-----------DDDDDDDDDDDDD");  
		logger.info("List-----------IIIIIIIIIIIIIIIIII");  
		logger.warn("List-----------WWWWWWWWWWWWWWWWWWWWWW");  
		logger.error("List-----------EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");  
		//Logger.error("异常信息");
		return "index";
	}
	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String addEntity(User entity, Model model, HttpServletRequest request){
		
		userService.addUser(entity);
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteEntity/{id}", method = RequestMethod.GET)
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String deleteEntity(@PathVariable("id") String id, Model model){
		
		userService.deleteUser(id);
		
		return "index";
	}
}