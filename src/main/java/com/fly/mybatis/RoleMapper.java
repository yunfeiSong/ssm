package com.fly.mybatis;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/11
 * @Copyright (c) 2015 jigoon
 */
public interface RoleMapper {

  Role getRole(int id);

  void addRole(Role role);

  void modify(Role role);

  void remove(int id);
}
