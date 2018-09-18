package com.fly.spring;

import org.springframework.stereotype.Component;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/6
 */

@Component("roleService2")
public class RoleServiceImpl2 implements RoleService {
  public void printRoleInfo(Role role) {

  }

  public void printRoleInfo() {

  }

  public void printRoleInfoAuto() {
    System.out.println("impl2实例化");
  }
}
