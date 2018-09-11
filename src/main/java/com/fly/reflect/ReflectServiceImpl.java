package com.fly.reflect;

import com.fly.reflect.proxy.HelloWorld;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/8/27
 * @Copyright (c) 2015 jigoon
 */


public class ReflectServiceImpl implements HelloWorld{

  public void sayHello(String name) {
    System.out.println("hello " + name);
  }

  public void sayHelloWorld() {
    System.out.println("ReflectServiceImpl HelloWorld");
  }
}
