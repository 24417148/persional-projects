package com.zyl.cases.proxy.cglibp;

public class App {

  public static void main(String[] args) {
    //目标对象
    UserDao target = new UserDao();
    PeopleDao target1 = new PeopleDao();
    //代理对象
    PeopleDao proxy = (PeopleDao)new ProxyFactory(target1).getProxyInstance();

    //执行代理对象的方法
    proxy.save();
  }

}
