package com.fly.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/11
 * @Copyright (c) 2015 jigoon
 */


public class Main {

  private static Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {

    //System.out.println(getSqlSessionFactory());
    //System.out.println(getSqlSessionFactory1());

    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();

      RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
      Role role = roleMapper.getRole(3);

      log.info(role.getRoleEnum().getDesc());

      Role newRole = new Role();
      newRole.setNote("添加员工");
      newRole.setRoleEnum(RoleEnum.Employee);
      roleMapper.addRole(newRole);
      newRole.setRoleEnum(RoleEnum.ChairMan);
      roleMapper.modify(newRole);
      roleMapper.remove(1);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    } finally {
      sqlSession.close();
    }

  }


  public static SqlSessionFactory getSqlSessionFactory1() {

    PooledDataSource dataSource = new PooledDataSource();
    dataSource.setDriver("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql:localhost:///mysql");
    dataSource.setUsername("root");
    dataSource.setPassword("123456");
    dataSource.setDefaultAutoCommit(false);

    TransactionFactory transactionFactory = new JdbcTransactionFactory();

    Environment environment = new Environment("development", transactionFactory, dataSource);

    Configuration configuration = new Configuration(environment);

    configuration.getTypeAliasRegistry().registerAlias("role", Role.class);

    configuration.addMapper(RoleMapper.class);

    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);


    return sqlSessionFactory;
  }


  /**
   * 构建 SqlSessionFactory 通过 xml 文件的方式
   *
   * @return SqlSessionFactory 实例
   */
  public static SqlSessionFactory getSqlSessionFactory() {

    SqlSessionFactory sqlSessionFactory = null;
    InputStream inputStream;
    String resource = "mybatis-config.xml";

    try {
      inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return sqlSessionFactory;
  }
}
