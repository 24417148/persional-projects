package com.zyl.cases.Jetty.service.impl;

import com.zyl.cases.Jetty.repository.UserDao;
import com.zyl.cases.Jetty.repository.entity.User;
import com.zyl.cases.Jetty.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

  @Resource
  private UserDao userDao;


  public User getUserById(String userId){
    return userDao.getUserById(userId);
  }


}
