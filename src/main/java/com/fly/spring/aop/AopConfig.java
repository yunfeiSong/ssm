package com.fly.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : SongYF
 * @desc : 生成切面，配置扫描包，开启aop自动代理
 * @date : 2018/9/10
 * @Copyright (c) 2015 jigoon
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.fly.spring.aop")
public class AopConfig {

  @Bean
  public RoleAspect1 getRoleAspect1() {
    return new RoleAspect1();
  }

  @Bean
  public RoleAspect2 getRoleAspect2() {
    return new RoleAspect2();
  }
}
