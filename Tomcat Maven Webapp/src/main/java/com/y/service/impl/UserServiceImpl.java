package com.y.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.y.dao.UserMapper;
import com.y.entity.PageView;
import com.y.entity.User;
import com.y.service.UserServiceI;






import java.util.List;

import javax.servlet.http.HttpServletRequest;


/**
 * @author gacl
 * 使用@Service注解将UserServiceImpl类标注为一个service
 * service的id是userService
 */
@Service("userService")
public class UserServiceImpl implements UserServiceI {

    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用UserMapper时，Spring就会自动注入UserMapper
     */
    @Autowired
    private UserMapper userMapper;//注入dao

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
        //userMapper.insertC(user);
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

	@Override
	public void deleteUser(String userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public List<User> getAllUserPage(int currentPage, int showCount) {
		// TODO Auto-generated method stub
		return userMapper.getAllUserPage(currentPage,  showCount);
	}

	@Override
	public PageView getUserPage(PageView pageView, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		 List<User> list = userMapper.getAllUserPage(pageView.getOffset(),  pageView.getLimit());
		 pageView.setRows(list);
		 pageView.setTotal(userMapper.getAllUser().size());
		 
		 
		 return pageView;
	}

	@Override
	public Integer validateUserName(String loginName) {
		//loginName  不能重复
		int counts = userMapper.selectByLoginName(loginName);
		
		return counts;
	}

	@Override
	public User getUserLogin(String loginName, String password) {
		// TODO Auto-generated method stub
		User  user = userMapper.selectUserLogin(loginName,password);
		return user;
	}

}