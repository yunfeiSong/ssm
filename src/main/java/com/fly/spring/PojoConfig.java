package com.fly.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : SongYF
 * @desc : 扫描器，默认扫描文件本包
 * @date : 2018/9/5
 */
@Configuration
@ComponentScan(basePackages = "com.fly.spring",basePackageClasses = Role.class)
public class PojoConfig {
}
