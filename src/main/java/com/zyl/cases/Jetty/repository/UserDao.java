package com.zyl.cases.Jetty.repository;

import com.zyl.cases.Jetty.repository.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

  User getUserById(String userId);

}
