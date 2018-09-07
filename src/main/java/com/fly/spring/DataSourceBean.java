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
 * @desc :
 * @date : 2018/9/7
 * @Copyright (c) 2015 jigoon
 */

@Component
@Conditional({DataSourceCondition.class})
public class DataSourceBean {
  @Value("${driver}")
  private String driverClassName;
  @Value("${url}")
  private String url;
  @Value("${username}")
  private String username;
  @Value("${password}")
  private String password;

  @Bean
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
