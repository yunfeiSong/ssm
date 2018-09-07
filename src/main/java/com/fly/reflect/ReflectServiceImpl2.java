package com.fly.reflect;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/8/27
 * @Copyright (c) 2015 jigoon
 */


public class ReflectServiceImpl2 {

  private String name;

  public ReflectServiceImpl2() {

  }

  public ReflectServiceImpl2(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void sayHello(String name) {
    System.out.println("hello " + name);
  }
}
