package com.fly.mybatis;

import org.springframework.stereotype.Repository;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/11
 * @Copyright (c) 2015 jigoon
 */

@Repository
public interface RoleMapper extends BaseMapper{

  Role getRole(int id);

  void addRole(Role role);

  void modify(Role role);

  void remove(int id);

  void countRole(RoleCountResult roleCountResult);
}
