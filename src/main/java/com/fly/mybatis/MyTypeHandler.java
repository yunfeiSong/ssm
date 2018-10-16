package com.fly.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : SongYF
 * @desc : 自定义 mybatis 类型处理器
 * @date : 2018/9/12
 */
/*可通过泛型指定想得到的 javaType ，也可以使用如下的注解方式，指定对应的 JavaType 和 jdbcType*/
//@MappedTypes(RoleEnum.class)
//@MappedJdbcTypes(JdbcType.INTEGER)
public class MyTypeHandler implements TypeHandler<RoleEnum> {

  public void setParameter(PreparedStatement preparedStatement, int i, RoleEnum roleEnum, JdbcType jdbcType) throws SQLException {

    preparedStatement.setInt(i,roleEnum.getValue());

  }

  public RoleEnum getResult(ResultSet resultSet, String s) throws SQLException {
    return RoleEnum.getByValue(resultSet.getInt(s));
  }

  public RoleEnum getResult(ResultSet resultSet, int i) throws SQLException {
    return RoleEnum.getByValue(resultSet.getInt(i));
  }

  public RoleEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
    return RoleEnum.getByValue(callableStatement.getInt(i));
  }
}
