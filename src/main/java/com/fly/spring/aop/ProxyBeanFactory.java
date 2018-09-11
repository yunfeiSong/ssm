package com.fly.spring.aop;

/**
 * @author : SongYF
 * @desc : Bean 的代理工厂类
 * @date : 2018/9/10
 * @Copyright (c) 2015 jigoon
 */


public class ProxyBeanFactory {

  public static <T> T getBean(T obj, Interceptor interceptor){

    return (T) ProxyBeanUtil.getBean(obj, interceptor);
  }
}
