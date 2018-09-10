package com.fly.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author : SongYF
 * @desc : 数据源
 * @date : 2018/9/7
 * @Copyright (c) 2015 jigoon
 */

@Component
public class DataSourceBean {
  @Value("${driver}")
  private String driverClassName;
  @Value("${url}")
  private String url;
  @Value("${username}")
  private String username;
  @Value("${password}")
  private String password;

  @Bean(name = "dataSource")
  @Conditional({DataSourceCondition.class})// 是否加载 Bean 的条件
  public DruidDataSource getDruidDataSource(){
    Properties properties = new Properties();
    properties.setProperty("driverClassName", driverClassName);
    properties.setProperty("url", url);
    properties.setProperty("username", username);
    properties.setProperty("password", password);

    DruidDataSource dataSource = null;
    try {
      dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dataSource;
  }
}
