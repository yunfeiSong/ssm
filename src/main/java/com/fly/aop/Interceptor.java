package com.fly.aop;

/**
 * @author : SongYF
 * @desc :  aop 自定义拦截器接口
 * @date : 2018/9/10
 * @Copyright (c) 2015 jigoon
 */
public interface Interceptor {

  /**
   * 前置通知
   */
  void before(Object obj);

  /**
   * 后置通知
   */
  void after(Object obj);

  /**
   * 返回通知
   */
  void afterReturning(Object obj);

  /**
   * 异常通知
   */
  void afterThrowing(Object obj);

}
