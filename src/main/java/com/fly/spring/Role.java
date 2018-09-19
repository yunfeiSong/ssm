package com.fly.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : SongYF
 * @desc : 角色表
 * @date : 2018/9/5
 */

public class Role {
  //@Value("董事长")
//  @Value("#{'董事长'}")// EL 表达式的方式，赋值
  @Value("#{null}")
  private String name;
  //@Value("1")
  @Value("#{1}")
  private String lev;

  public Role() {
  }

   public Role(String name, String lev) {
    this.name = name;
    this.lev = lev;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLev() {
    return lev;
  }

  public void setLev(String lev) {
    this.lev = lev;
  }

  @Override
  public String toString() {
    return "Role{" +
      "name='" + name + '\'' +
      ", lev='" + lev + '\'' +
      '}';
  }
}
