package com.fly.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/5
 * @Copyright (c) 2015 jigoon
 */
@Configuration
@ComponentScan(basePackages = "com.fly.spring",basePackageClasses = Role.class)
public class PojoConfig {
}
