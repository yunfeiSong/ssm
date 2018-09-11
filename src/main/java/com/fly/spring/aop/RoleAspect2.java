package com.fly.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author : SongYF
 * @desc : aspect 切面实体类，被代理若对象实现了接口，则使用jdk动态代理，否则使用CGLIB动态代理
 * @date : 2018/9/10
 * @Copyright (c) 2015 jigoon
 */

@Aspect
@Order(1)
public class RoleAspect2 {

  //在RoleServiceImpl 类中引入新的接口，RoleVerifierImpl，+ 号表示该类的所有子类
  @DeclareParents(value = "com.fly.spring.aop.RoleServiceImpl+",defaultImpl = RoleVerifierImpl.class)
  public RoleVerifier roleVerifier;

  /**
   * 切点
   */
  @Pointcut("execution(* com.fly.spring.aop.RoleServiceImpl.printRoleInfo(..)))")
  public void print(){

  }

  /**
   * 前置通知
   */
  @Before("print() && args(role, sort)") //args 传入参数,对象和常量
  public void before(Role role, int sort) {
    System.out.println("前置通知执行-2"+role+sort);
  }

  /**
   * 后置通知
   */
  @After("print()")
  public void after() {
    System.out.println("后置通知执行-2");
  }

  /**
   * 返回通知
   */
  @AfterReturning("print()")
  public void afterReturning() {
    System.out.println("返回通知执行-2");
  }

  /**
   * 异常通知
   */
  @AfterThrowing("print()")
  public void afterThrowing() {
    System.out.println("异常通知执行-2");
  }

  /**
   * 环绕通知
   */
  @Around("print()")
  public void around(ProceedingJoinPoint pj) {
    System.out.println("环绕通知执行-2-before");
    try {
      pj.proceed();//不执行，则会覆盖原有方法
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    System.out.println("环绕通知执行-2-after");
  }

}
