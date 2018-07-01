package com.zyl.cases.proxy.dynamicp;

public class UserDao implements IUserDao {

  @Override
  public void save() {

    System.out.println("-----------------UserDao -- save");


  }
}
