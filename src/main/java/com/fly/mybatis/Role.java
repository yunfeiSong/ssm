package com.fly.mybatis;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author : SongYF
 * @desc : Role 角色表实体类
 * @date : 2018/9/11
 */

@Component
public class Role implements Serializable {

  private static final long serialVersionUID = 3582032464867226659L;

  private int id;

  private RoleEnum roleEnum;

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

  public RoleEnum getRoleEnum() {
    return roleEnum;
  }

  public void setRoleEnum(RoleEnum roleEnum) {
    this.roleEnum = roleEnum;
  }

  @Override
  public String toString() {
    return "Role{" +
      "id=" + id +
      ", roleEnum=" + roleEnum +
      ", note='" + note + '\'' +
      '}';
  }
}
