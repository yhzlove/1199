package com.y.web.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.y.entity.PageView;
import com.y.entity.User;
import com.y.service.UserServiceI;

@Controller
@RequestMapping("/user/")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	private UserServiceI userService;

	private User user;

	@Autowired(required = true)
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@RequestMapping("list")
	public String listUI(HttpServletRequest request,Model model) throws Exception {
//		List<User> lstUsers = userService.getAllUser();
//
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		modelMap.put("rows", JSON.toJSON(lstUsers));
//		modelMap.put("total", 100);
//		model.addAttribute("page", modelMap);
//		// logger.debug("List-----------");
//		// logger.debug("List-----------DDDDDDDDDDDDD");
//		// logger.info("List-----------IIIIIIIIIIIIIIIIII");
//		// logger.warn("List-----------WWWWWWWWWWWWWWWWWWWWWW");
//		// logger.error("List-----------EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//		// //Logger.error("异常信息");
//		// //logs debug message
//		// if(logger.isDebugEnabled()){
//		// logger.debug("getWelcome is executed!");
//		// }
//		//
//		// //logs exception
//		// logger.error("This is Error message", new Exception("Testing"));
		return "/user/userlist";
	}

	@ResponseBody
	@RequestMapping("listJSON")
	public Map listUIJSON(PageView pageView,HttpServletRequest request) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		//分页  + request
		pageView = userService.getUserPage(pageView, request);
		
		map.put("rows",pageView.getRows());
		map.put("total", pageView.getTotal());

		
		return map;
	}

	@RequestMapping(value = "useradd", method = RequestMethod.GET)
	public String addEntity() {

		return "/user/useradd";
	}
	
	@RequestMapping(value = "useradd_v", method = RequestMethod.GET)
	public String addEntity_v() {

		return "/user/useradd_v";
	}

	/**
	 * Object 可以 Map 可以
	 * 
	 * 2016年8月31日 下午4:36:25
	 * 
	 * @author yanhz
	 */
	@ResponseBody
	@RequestMapping("addEntity")
	public Map addEntity(User entity, Model model, HttpServletRequest request) {
		
		UUID uuid = UUID.randomUUID();
		entity.setUserId(uuid.toString().replace("-", ""));
		userService.addUser(entity);

		// model.addAttribute("success", "true");
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", "1");
		modelMap.put("data", "1");
		modelMap.put("success", "true");
		// ModelAndView mav=new ModelAndView("user/useradd",modelMap);

		return modelMap;

	}

	@ResponseBody
	@RequestMapping(value = "/deleteEntity/{id}", method = RequestMethod.GET)
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	public String deleteEntity(@PathVariable("id") String id, Model model) {

		userService.deleteUser(id);

		return "index";
	}
}