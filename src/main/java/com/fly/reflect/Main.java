package com.fly.reflect;

import com.fly.reflect.proxy.CGLIBProxyExample;
import com.fly.reflect.proxy.HelloWorld;
import com.fly.reflect.proxy.JDKProxyExample;

import java.lang.reflect.Method;

public class Main {

  public static void main(String[] args) {
    //System.out.println("Hello World!");
    //getInstance();
    //getInstance2().getName();
    //reflectMethod();
    //reflectObject();
    //testJDKProxy();
    CGLIBProxy();
  }

  public static void CGLIBProxy(){
    CGLIBProxyExample CGLIBProxy = new CGLIBProxyExample();
    ReflectServiceImpl2 proxy = (ReflectServiceImpl2) CGLIBProxy.getProxy(ReflectServiceImpl2.class);
    proxy.sayHello("张三");
  }

  /**
   * 测试JDK代理实例
   */
  public static void testJDKProxy() {
    //JDKProxyExample jdkProxy = new JDKProxyExample();
    JDKProxyExample jdkProxy = null;
    try {
      jdkProxy = (JDKProxyExample) Class.forName("com.fly.reflect.proxy.JDKProxyExample").newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    //HelloWorld proxy = (HelloWorld) jdkProxy.bind(new HelloWorldImpl());
    HelloWorld proxy = (HelloWorld) jdkProxy.bind(new ReflectServiceImpl());
    proxy.sayHelloWorld();
  }

  /**
   * 通过反射生成对象和其方法
   *
   * @return 生成的对象
   */
  public static Object reflectObject() {
    ReflectServiceImpl2 returnObj = null;
    try {
      returnObj = (ReflectServiceImpl2) Class.forName("com.fly.reflect.ReflectServiceImpl2").newInstance();
      Method method = returnObj.getClass().getMethod("sayHello", String.class);
      method.invoke(returnObj, "张三");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return returnObj;
  }

  /**
   * class.getMethod() 反射生成方法
   */
  public static Object reflectMethod() {
    Object returnObj = null;
    ReflectServiceImpl target = new ReflectServiceImpl();
    try {
      //Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
      Method method = target.getClass().getMethod("sayHello", String.class);
      returnObj = method.invoke(target, "张三");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return returnObj;
  }

  /**
   * 反射生成有参对象
   */
  public static ReflectServiceImpl2 getInstance2() {
    ReflectServiceImpl2 object = null;
    try {
      object = (ReflectServiceImpl2) Class.forName("com.fly.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return object;
  }

  /**
   * Class.forName 反射生成对象
   */
  public static ReflectServiceImpl getInstance() {
    ReflectServiceImpl object = null;
    try {
      object = (ReflectServiceImpl) Class.forName("com.fly.reflect.ReflectServiceImpl").newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return object;
  }
}
