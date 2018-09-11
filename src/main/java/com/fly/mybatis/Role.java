package com.fly.mybatis;

/**
 * @author : SongYF
 * @desc : Role 角色表实体类
 * @date : 2018/9/11
 * @Copyright (c) 2015 jigoon
 */


public class Role {

  private int id;
  private String roleName;
  private String note;

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


}
