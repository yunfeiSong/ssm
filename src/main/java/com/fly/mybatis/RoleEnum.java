package com.fly.mybatis;

/**
 * @Desc : 角色类型枚举类
 * @Author : SongYF
 * @Date : 2018/9/12 10:43
 * @Copyright (c) 2015 jigoon
 */
public enum RoleEnum {

  Manager(0, "经理"),
  ChairMan(11, "董事长"),
  Employee(2, "员工");

  private int value;

  private String desc;

  RoleEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public static RoleEnum getByValue(int value) {
    for (RoleEnum re : RoleEnum.values()) {
      if (re.getValue() == value) {
        return re;
      }
    }
    return null;
  }
}
