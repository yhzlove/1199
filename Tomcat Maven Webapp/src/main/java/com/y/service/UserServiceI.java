package com.y.service;

import com.y.entity.PageView;
import com.y.entity.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


public interface UserServiceI {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
    
    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    User getUserById(String userId);
    
    /**
     *删除
     * @param user
     */
    void deleteUser(String userId);
    
    /**获取所有用户信息
     * @return List<User>
     */
    List<User> getAllUser();

	List<User> getAllUserPage(int currentPage, int showCount);

	PageView getUserPage(PageView pageView, HttpServletRequest request);

	Integer validateUserName(String loginName);

	User getUserLogin(String loginName, String password);
}
