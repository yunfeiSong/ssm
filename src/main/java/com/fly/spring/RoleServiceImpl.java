package com.fly.spring;

import com.fly.mybatis.RoleMapper;
import com.fly.mybatis.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/5
 */

@Service("roleService1")
/*
* ★★★★★
* @transactional 注解在静态方法和非 public 方法之上 无效，自调用：在类自身中，一个方法调用另一个方法也无效
* 几点注意事项：
*       ★★   1、事务通常加在 service 层，当调用 service 层方法结束时，当前事务将释放，如果在一段代码中连续调用同一 service 方法对次，则会产生多个事务
*       ★★   2、在事务层的方法中，不应有过多和数据库事务无关的代码，否则会大量占用事务时间，造成应用卡顿、宕机
*       ★★   3、在存在事务的情况下，使用try catch 手动捕获异常后，一定要在最后抛出，spring 才会将事务进行回滚
*
*
* value：事务管理器在 IOC 容器中的 id
* propagation：事务的传播行为，默认值为 Propagation.REQUIRED
*      REQUIRED(0),默认的传播行为，当前存在事务就不再创建新的事务
*      SUPPORTS(1),当前存在事务就在事务中执行，不存在则不启用事务
*      MANDATORY(2),必须在事务内运行，否则抛出异常
*      REQUIRES_NEW(3),无论当前是否存在事务，都创建新的事务
*      NOT_SUPPORTED(4),不支持事务，如果存在当前事务，则将事务挂起，执行完毕后恢复挂起的事务
*      NEVER(5),不支持事务，如过当前存在事务，则抛出异常
*      NESTED(6)，嵌套事务，如果调用此方法时出现异常，则只回滚此方法，不影响主方法，如果数据库支持 savepoint 则回滚至 保存点
*
* isolation：事务的隔离级别，默认值为数据库的隔离级别，隔离级别越高，性能越低，高并发的应用场景下通常采用 读/写提交 的隔离级别，解决基本的脏读，
*   DEFAULT(-1)：默认的隔离级别随数据库的隔离级别而定，mysql支持四种隔离级别，默认的为 可重复读，oracle 支持读/写提交、序列化 两种级别，默认的为 读/写提交
*   READ_UNCOMMITTED(1)：脏读（读/写未提交）
*    READ_COMMITTED(2)：读/写提交，可解决脏读的错误场景
*    REPEATABLE_READ(4)：可重复读，可解决不可重复读的错误场景
*    SERIALIZABLE(8)：序列化，可解决幻读的错误场景
*
* timeout：（秒）事务的超时时间，超时后会发生异常，导致事务回滚
* rollbackForClassName：发生该异常时，事务才会进行回滚
* noRollbackForClassName：发生该异常时，事务仍提交
* */
//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,timeout = 3, rollbackForClassName = "java.lang.Exception", value = "transactionManager")
//@Primary 接口有多个实现类时，primary指定最先选择实例化的类
public class RoleServiceImpl implements RoleService {

  //@Autowired(required = false)
  private Role role = null;

  @Autowired
  private RoleMapper roleMapper;


  @Autowired
  private RoleService roleService1;

  @Autowired//采用setter注入需要的 bean
  private void setRole(Role role) {
    this.role = role;
  }

  public void printRoleInfoAuto() {
    System.out.println(role);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @CachePut(value = "redisCacheManager", key = "'cache_put_role_'+#result.id")
//  开启缓存，value 指定缓存器，key 指定保存所用的名称
//  #result 为 spring 和 redis 的约定，代表引用方法的返回值，
//  也可以通过，#参数名，引用方法签名中的参数
  public Role addRole(Role role) {
    roleMapper.addRole(role);
    return role;
  }

  public Role getRole(int id) {
    return roleMapper.getRole(id);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  //注意的是，调用该方法，并不会触发该类中 addRole（）方法，这里产生了自调用问题，缓存本质基于 spring 的 AOP 所以自身不能代理自身
  public void addListRole(ArrayList<Role> roles) {
    for (Role r : roles) {
      roleService1.addRole(r);
      /* 发生除零异常后，只回滚当前方法 */
     /* Role role1 = new Role();
      role1.setRoleEnum(RoleEnum.Manager);
      role1.setNote(String.valueOf(100/0));
      roleService1.addRole(role1);*/
    }
  }

  public void printRoleInfo(Role role) {

  }

  public void printRoleInfo() {
    System.out.println("RoleService实例化");
  }
}
