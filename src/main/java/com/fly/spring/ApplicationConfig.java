package com.fly.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author : SongYF
 * @desc : 配置类，扫描器+资源文件定位
 * @date : 2018/9/7
 */

//@Configuration
//@ComponentScan(basePackages = "com.*")
//@PropertySource(value = "classpath:dataSource.properties"/* , ignoreResourceNotFound = true*/)
public class ApplicationConfig {

  @Bean
  // Bean 工厂后置处理器实现类的子类
  public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
    return new PropertySourcesPlaceholderConfigurer();
  }

}
