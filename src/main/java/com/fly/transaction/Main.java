package com.fly.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc :
 * @Author : SongYF
 * @Date : 2018/9/17 17:33
 */

public class Main {
  @Autowired
  private static DruidDataSource dataSource;

  public static void main(String[] args) {
    System.out.println(dataSource.getUrl());
    ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
    DruidDataSource dataSource = (DruidDataSource) ctx.getBean("dataSource1");
    //System.out.println(dataSource.getUrl());
    ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    DruidDataSource dataSource1 = (DruidDataSource) ctx.getBean("dataSource");
    //System.out.println(dataSource1.getUrl());
  }

}
