package com.fly.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/5
 * @Copyright (c) 2015 jigoon
 */

@Component
public class Role {
  @Value("董事长")
  private String name;
  @Value("1")
  private String lev;

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
