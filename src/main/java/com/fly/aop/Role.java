package com.fly.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : SongYF
 * @desc : 角色表
 * @date : 2018/9/5
 * @Copyright (c) 2015 jigoon
 */

@Component
public class Role {
  private String name;
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
