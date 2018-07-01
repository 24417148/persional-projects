package com.zyl.cases.Jetty.repository.entity;

public class User {


    private String userId;

    private String name;

    private String pwd;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPwd() {
      return pwd;
    }

    public void setPwd(String pwd) {
      this.pwd = pwd;
    }

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }
}
