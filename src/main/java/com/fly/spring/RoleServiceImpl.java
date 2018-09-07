package com.fly.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/5
 * @Copyright (c) 2015 jigoon
 */

@Component("roleService1")
//@Primary 接口有多个实现类时，primary指定最先选择实例化的类
public class RoleServiceImpl implements RoleService {

  //@Autowired(required = false)
  private Role role = null;

  @Autowired//采用setter注入需要的 bean
  private void setRole(Role role){
    this.role = role;
  }

  public void printRoleInfoAuto(){
    System.out.println(role);
  }

  public void printRoleInfo(Role role) {
    System.out.println(role);
  }

  public void printRoleInfo() {
    System.out.println("RoleService实例化");
  }
}
