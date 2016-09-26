package com.y.dao;

import java.util.List;

import com.y.entity.UserFormMap;



public interface UserMapper {

	public List<UserFormMap> findUserPage(UserFormMap userFormMap);

	public List<UserFormMap> findByNames(UserFormMap userFormMap);
	
}
