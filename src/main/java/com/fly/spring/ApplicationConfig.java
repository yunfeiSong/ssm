package com.fly.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/7
 * @Copyright (c) 2015 jigoon
 */

@Configuration
@ComponentScan(basePackages = "com.fly.spring")
@PropertySource(value = "classpath:dataSource.properties" , ignoreResourceNotFound = true)
public class ApplicationConfig {

  @Bean
  public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
    return new PropertySourcesPlaceholderConfigurer();
  }

}
