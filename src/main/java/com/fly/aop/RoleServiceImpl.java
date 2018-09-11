package com.fly.aop;

import org.springframework.stereotype.Component;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/5
 * @Copyright (c) 2015 jigoon
 */

@Component("roleService")
public class RoleServiceImpl implements RoleService {

  public void printRoleInfo(Role role, int sort) {
    System.out.println(role);
    System.out.println(sort);
  }

}
