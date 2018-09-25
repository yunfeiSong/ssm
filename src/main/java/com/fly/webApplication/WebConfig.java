package com.fly.webApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Desc : java 配置文件
 * @Author : SongYF
 * @Date : 2018/9/20 14:38
 */

/*
@Configuration
@ComponentScan("com.*")
@EnableWebMvc
*/
public class WebConfig {

  @Bean("viewResolver")
  public ViewResolver initViewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/pages/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }
}
