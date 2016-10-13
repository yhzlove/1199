package com.y.service.impl;











import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.y.dao.ResourcesMapper;
import com.y.entity.ResFormMap;
import com.y.service.ResServiceI;


/**
 * @author gacl
 * 使用@Service注解将UserServiceImpl类标注为一个service
 * service的id是userService
 */
@Service("resrService")
public class ResServiceImpl implements ResServiceI {

    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用UserMapper时，Spring就会自动注入UserMapper
     */
    @Autowired
    private ResourcesMapper resourcesMapper;//注入dao

   

    @Override
    public List<ResFormMap> getAllRes() {
        return resourcesMapper.getAllRes();
    }

	


}