package com.fly.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

/**
 * @Desc : java 配置生成事务管理器
 * @Author : SongYF
 * @Date : 2018/9/17 17:16
 */
//@Configuration//标识为 java 配置类
//@EnableTransactionManagement //开启事务管理
//@ComponentScan(basePackages = "com.fly.transaction") //基本扫描包
//@PropertySource(value = "classpath:dataSource.properties")
public class JavaConfig{
  /**
   * 解析占位符 ${}
   */
  @Bean
  public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  private DruidDataSource dataSource;

  @Value("${jdbc_username}")
  private String username;

  @Value("${jdbc_password}")
  private String password;

  @Value("${jdbc_url}")
  private String url;

  @Value("${jdbc_driver}")
  private String driver;

  /**
   * 配置生成数据源
   *
   * @return 数据源
   */
  @Bean(name = "dataSource1")
  public DruidDataSource getDruidDataSource() {
    if (dataSource != null) {
      return dataSource;
    }
    Properties prop = new Properties();
    prop.setProperty("username", username);
    prop.setProperty("password", password);
    prop.setProperty("url", url);
    prop.setProperty("driverClassName", driver);

    try {
      dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return dataSource;
  }

  @Bean(name = "jdbcTemplate")
  public JdbcTemplate initJdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(getDruidDataSource());
    return jdbcTemplate;
  }

  /**
   * @return 自定义事务管理器
   */
  @Bean(name = "transactionManager")
  public PlatformTransactionManager txManager() {
    return new DataSourceTransactionManager(getDruidDataSource());
  }

  public PlatformTransactionManager annotationDrivenTransactionManager() {
    return txManager();
  }

}
