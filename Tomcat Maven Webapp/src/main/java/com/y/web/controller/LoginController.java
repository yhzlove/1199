package com.y.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.y.annotation.SystemControllerLog;
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
	//此处为记录AOP拦截Controller记录用户操作    
	@SystemControllerLog(description = "登入用户")
	public String login(String  loginName,String  password, Model model, HttpServletRequest request){
		try {
			if (!request.getMethod().equals("POST")) {
				request.setAttribute("error", "支持POST方法提交！");
			}
			if (Common.isEmpty(loginName) || Common.isEmpty(password)) {
				request.setAttribute("error", "用户名或密码不能为空！");
				return "/login";
			}
			// 想要得到 SecurityUtils.getSubject()　的对象．．访问地址必须跟ｓｈｉｒｏ的拦截地址内．不然后会报空指针
			Subject user = SecurityUtils.getSubject();
			// 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
			// 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
			// 当以上认证成功后会向下执行,认证失败会抛出异常
			UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
			try {
				user.login(token);
			} catch (LockedAccountException lae) {
				token.clear();
				request.setAttribute("error", "用户已经被锁定不能登录，请与管理员联系！");
				return "/login";
			} catch (ExcessiveAttemptsException e) {
				token.clear();
				request.setAttribute("error", "账号：" + loginName + " 登录失败次数过多,锁定10分钟!");
				return "/login";
			} catch (AuthenticationException e) {
				token.clear();
				request.setAttribute("error", "用户或密码不正确！");
				return "/login";
			}
//			UserLoginFormMap userLogin = new UserLoginFormMap();
//			Session session = SecurityUtils.getSubject().getSession();
//			userLogin.put("userId", session.getAttribute("userSessionId"));
//			userLogin.put("accountName", loginName);
//			userLogin.put("loginIP", session.getHost());
//			userLoginMapper.addEntity(userLogin);
			request.removeAttribute("error");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "登录异常，请联系管理员！");
			return "/login";
		}
		//return "redirect:index.shtml";
//		if (Common.isEmpty(loginName) || Common.isEmpty(password)) {
//			request.setAttribute("error", "用户名或密码不能为空！");
//			return "/login";
//		}
//		
//		User user = userService.getUserLogin(loginName,password);
//		
//		if(user==null)
//			return "/login";
//		
//		
		return "index";
	}
	
}
