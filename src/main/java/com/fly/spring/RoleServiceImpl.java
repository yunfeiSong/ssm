package com.fly.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/5
 */

@Component("roleService1")
/*
* value：事务管理器在 IOC 容器中的 id
* propagation：事务的传播行为，默认值为 Propagation.REQUIRED
* isolation：事务的隔离级别，默认值为数据库的隔离级别
* timeout：事务的超时时间，超时后会发生异常，导致事务回滚
* rollbackForClassName：发生该异常时，事务才会进行回滚
* noRollbackForClassName：发生该异常时，事务仍提交
* */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,timeout = 3, rollbackForClassName = "java.lang.Exception", value = "transactionManager")
//@Primary 接口有多个实现类时，primary指定最先选择实例化的类
public class RoleServiceImpl implements RoleService {

  //@Autowired(required = false)
  private Role role = null;

  @Autowired//采用setter注入需要的 bean
  private void setRole(Role role){
    this.role = role;
  }

  public void printRoleInfoAuto(){
    System.out.println(role);
  }

  public void printRoleInfo(Role role) {
    System.out.println(role);
  }

  public void printRoleInfo() {
    System.out.println("RoleService实例化");
  }
}
