package com.fly.reflect.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/8/29
 * @Copyright (c) 2015 jigoon
 */


public class CGLIBProxyExample implements MethodInterceptor {

  /**
   * 生成 CGLIB 代理对象
   * @param cls class 类
   * @return class 类的 CGLIB 代理对象
   */
  public Object getProxy(Class cls) {
    Enhancer enhancer = new Enhancer(); // CGLIB 的 Enhancer 增强类对象
    enhancer.setSuperclass(cls); // 设置增强类型
    enhancer.setCallback(this); // 定义代理逻辑对象为当前对象，要求当前对象实现 MethodInterceptor 接口

    return enhancer.create(); // 生成并返回代理对象
  }

  /**
   * 代理逻辑方法
   * @param o 代理对象
   * @param method 方法
   * @param objects 方法参数
   * @param methodProxy 方法代理
   * @return 代理逻辑返回
   * @throws Throwable 异常
   */
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
    System.out.println("调用真实对象前");
    Object obj = methodProxy.invokeSuper(o,objects); // CGLIB 反射调用真是对象方法
    System.out.println("调用真实对象后");
    return obj;
  }
}
