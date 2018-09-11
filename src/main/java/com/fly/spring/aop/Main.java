package com.fly.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/10
 * @Copyright (c) 2015 jigoon
 */


public class Main {
  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
    RoleService service = (RoleService) ctx.getBean("roleService");
    //检查器，是否为null
    //在切面RoleAspect中,引入了RoleVerifier接口，所以RoleServiceImpl同时也是RoleVerifier的实现类
    //在aop实现动态代理的过程中，被代理对象下挂了两个接口，所以可以进行强转
    RoleVerifier roleVerifier = (RoleVerifier) service;

    Role role = new Role("总经理", "2");
    if (roleVerifier.verify(role)) {
      service.printRoleInfo(role, 1);
    }
//    role = null;
//    service.printRoleInfo(role);
  }
}
