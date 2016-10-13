package com.y.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.y.dao.ResourcesMapper;
import com.y.entity.PageView;
import com.y.entity.ResFormMap;
import com.y.util.Common;

//import com.lanyuan.annotation.SystemLog;
//import com.lanyuan.controller.index.BaseController;
//import com.lanyuan.entity.ButtomFormMap;
//import com.lanyuan.entity.Params;
//import com.lanyuan.entity.ResFormMap;
//import com.lanyuan.entity.ResUserFormMap;
//import com.lanyuan.entity.UserGroupsFormMap;
//import com.lanyuan.mapper.ResourcesMapper;
//import com.lanyuan.util.Common;
//import com.lanyuan.util.TreeObject;
//import com.lanyuan.util.TreeUtil;

/**
 * 
 * @author lanyuan 2014-11-19
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/resources/")
public class ResourcesController  {
	@Inject
	private ResourcesMapper resourcesMapper;
	

	@ResponseBody
	@RequestMapping("reslists")
	public Map reslists(PageView pageView,HttpServletRequest request) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		//分页  + request
		List<ResFormMap> list = resourcesMapper.getAllRes();
		
		map.put("rows",list);
		map.put("total", 100);

		
		return map;
	}

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model) {
		return "/resources/list";
	}

	
}