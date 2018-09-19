package com.fly.spring;

import com.fly.mybatis.RoleCountResult;
import com.fly.mybatis.Role;

import java.util.ArrayList;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/5
 */
public interface RoleService {
  /**
   * 打印角色信息
   **/
//  public void printRoleInfo(Role role);
  public void printRoleInfo();
  public void printRoleInfoAuto();

  void addRole(Role role);


  void addListRole(ArrayList<Role> roles);

}
