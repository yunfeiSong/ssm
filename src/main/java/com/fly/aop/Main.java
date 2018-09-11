package com.fly.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/10
 * @Copyright (c) 2015 jigoon
 */


public class Main {
  public static void main(String [] args){
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
    RoleService service = (RoleService) ctx.getBean("roleService");
    Role role = new Role("总经理", "2");
    service.printRoleInfo(role,1);
//    role = null;
//    service.printRoleInfo(role);
  }
}
