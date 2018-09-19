package com.fly.spring;

import com.fly.mybatis.*;
import com.fly.mybatis.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @Desc :
 * @Author : SongYF
 * @Date : 2018/9/19 10:36
 */

@Service("roleListService")
public class RoleListServiceImpl implements RoleListService {

  @Autowired
  private RoleService roleService1;

  @Transactional(propagation = Propagation.REQUIRED)
  public void addListRole(ArrayList<Role> roles) {
    for(Role r : roles){
      roleService1.addRole(r);
      /* 发生除零异常后，只回滚当前方法 */
      Role role1 = new Role();
      role1.setRoleEnum(RoleEnum.Manager);
      role1.setNote(String.valueOf(100/0));
      roleService1.addRole(role1);
    }
  }
}
