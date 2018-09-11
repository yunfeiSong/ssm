package com.fly.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author : SongYF
 * @desc : aspect 切面实体类
 * @date : 2018/9/10
 * @Copyright (c) 2015 jigoon
 */

@Aspect
public class RoleAspect {

  /**
   * 切点
   */
  @Pointcut("execution(* com.fly.aop.RoleServiceImpl.printRoleInfo(..)))")
  public void print(){

  }

  /**
   * 前置通知
   */
  @Before("execution(* com.fly.aop.RoleServiceImpl.printRoleInfo(..))) && args(role, sort)")
  public void before(Role role, int sort) {
    System.out.println("前置通知执行");
  }

  /**
   * 后置通知
   */
  @After("print()")
  public void after() {
    System.out.println("后置通知执行");
  }

  /**
   * 返回通知
   */
  @AfterReturning("print()")
  public void afterReturning() {
    System.out.println("返回通知执行");
  }

  /**
   * 异常通知
   */
  @AfterThrowing("print()")
  public void afterThrowing() {
    System.out.println("异常通知执行");
  }

  /**
   * 环绕通知
   */
  @Around("print()")
  public void around(ProceedingJoinPoint pj) {
    System.out.println("环绕通知执行-before");
    try {
      pj.proceed();//不执行，则会覆盖原有方法
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    System.out.println("环绕通知执行-after");
  }

}
