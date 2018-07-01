package com.zyl.cases.proxy.staticp;

public class UserDaoProxy implements IUserDao {

  private IUserDao target;
  public UserDaoProxy(IUserDao target){
    this.target=target;
  }

  public void save() {
    System.out.println("开始事务...");
    target.save();
    System.out.println("提交事务...");
  }


}
