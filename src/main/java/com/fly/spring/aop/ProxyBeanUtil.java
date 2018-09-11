package com.fly.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : SongYF
 * @desc : 动态代理类
 * @date : 2018/9/10
 * @Copyright (c) 2015 jigoon
 */


public class ProxyBeanUtil implements InvocationHandler {

  /**
   * 真实对象
   */
  private Object target = null;

  /**
   * 真实对象实现的接口-拦截器
   */
  private Interceptor interceptor = null;

  /**
   * 生成代理对象
   *
   * @param obj         被代理对象
   * @param interceptor 被代理对象实现的接口
   * @return 动态代理对象
   */
  public static Object getBean(Object obj, Interceptor interceptor) {
    ProxyBeanUtil _this = new ProxyBeanUtil();//实例化代理类
    _this.target = obj; //保存被代理对象
    _this.interceptor = interceptor; //保存其接口
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this); //生成代理对象
  }

  /**
   * 代理类执行的代理方法，当被代理类的方法被执行时，会进入此方法
   *
   * @param proxy  代理对象
   * @param method 调度方法-被代理方法
   * @param args   方法参数
   * @return 方法返回
   * @throws Throwable 异常
   */
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    Object returnObj = null;//返回值

    Boolean flag = false;//是否有异常

    interceptor.before(target);//前置方法

    try {
      returnObj = method.invoke(proxy, args);//反射原方法
    } catch (Exception e) {
      flag = true;
    } finally {
      interceptor.after(target);//后置方法
    }
    if (flag) {
      interceptor.afterThrowing(target);//异常方法
    } else {
      interceptor.afterReturning(target);//返回方法
    }
    return returnObj;
  }
}
