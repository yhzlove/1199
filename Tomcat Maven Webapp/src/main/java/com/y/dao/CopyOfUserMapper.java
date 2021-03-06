package com.y.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.y.entity.User;



public interface CopyOfUserMapper {

    int insert(User record);
    
    int insertC(User record);

//    int insertSelective(User record);

    User selectByPrimaryKey(String userId);
    
    int selectByLoginName(String loginName);

//    int updateByPrimaryKeySelective(User record);

//    int updateByPrimaryKey(User record);
    
    int deleteByPrimaryKey(String userId);
    /**获取所有用户信息
     * @return List<User>
     */
    List<User> getAllUser();

	List<User> getAllUserPage(@Param("currentPage") int currentPage,@Param("showCount") int showCount);

	User selectUserLogin(@Param("loginName")String loginName, @Param("password")String password);
}