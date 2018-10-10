package com.fly.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.fly.mybatis.RoleEnum;
import com.fly.mybatis.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleList;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/5
 */

@Component
public class Main {

  @Autowired//默认以 byType 类型注入 bean ，当注入的是接口有多个实现类时，按参数名和类的别名相匹配
  //@Qualifier("roleService2")//多个类继承自一个接口时，qualifier 指定固定别名的类实例化
  private RoleService roleService1;
//  private static RoleService roleService1; 不能注入静态变量

  @Autowired
  private RoleListService roleListService;

  @Autowired
  private User user;


  public static void main(String args[]) throws SQLException {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    RoleService roleService = (RoleService) ctx.getBean("roleService1");

    ArrayList<Role> roles = new ArrayList<Role>();
    for(int i=0;i<3;i++){
      Role role = new Role();
      role.setRoleEnum(RoleEnum.ChairMan);
      role.setNote("事务-主席"+i);
      roles.add(role);

    }

    roleService.addListRole(roles);
//
//    Role role2 = new Role();
//    role2.setRoleEnum(RoleEnum.Manager);
//    role2.setNote("事务-经理");
//    roles.clear();
//    roles.add(role2);
//    roleService.addListRole(roles);




//    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//    RoleMapper bean = ctx.getBean(RoleMapper.class);
//    com.fly.mybatis.Role role = bean.getRole(8);
//    System.out.println(role.getNote());
//    SimpleDriverDataSource springDataSource = (SimpleDriverDataSource) ctx.getBean("springDataSource");
//    System.out.println(springDataSource.getConnection());
    //DruidDataSource dataSource = (DruidDataSource) ctx.getBean("dataSource");
    //System.out.println(dataSource.getUrl());
    //User user = (User) ctx.getBean("com.fly.spring.User#0");//bean 无 id 时使用：全先顶名#数字
//    User user = (User) ctx.getBean("user1");//获得id
//    User user = ctx.getBean(User.class);//使用class
//    System.out.println(user.getLists().get(0));
//    Iterator iterator = user.getSets().iterator();
//    while (iterator.hasNext()){
//      System.out.println(iterator.next());
//    }
//      System.out.println(user.getMaps());
//      System.out.println(user.getPros());
//      System.out.println(user.getArrays()[0]);
//    System.out.println(user);

   /* ctx = new AnnotationConfigApplicationContext(PojoConfig.class);
    RoleService service = (RoleService) ctx.getBean("roleService1");
    Role role = ctx.getBean(Role.class);
    service.printRoleInfo(role);
    ELBean eLBean = (ELBean) ctx.getBean("eLBean");
    System.out.println(eLBean);*/
//    service.printRoleInfo();
//    service.printRoleInfoAuto();
    //ctx.getBean(Main.class).roleService1.printRoleInfoAuto();
    //System.out.println(ctx.getBean(Main.class).user);
    //System.out.println(ctx.getBean(Main.class).dataSource.getUrl());
    //ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    //System.out.println(ctx.getEnvironment().getProperty("url"));

    /**
     * spring EL 表达式
     */
    //表达式解析器
    /* ExpressionParser parser = new SpelExpressionParser();
    //表达式
    Expression exp = parser.parseExpression("'Hello World !'");
   String str = (String) exp.getValue();
    System.out.println(str);
    //通过 EL 访问普通方法
    exp = parser.parseExpression("'Hello World !'.charAt(0)");
    System.out.println(exp.getValue());
    //通过 EL 访问 getter 方法
    exp = parser.parseExpression("'Hello World !'.bytes");
    System.out.println(exp.getValue());
    //通过 EL 访问属性
    exp = parser.parseExpression("'Hello World !'.getBytes().length");
    System.out.println(exp.getValue());
    exp = parser.parseExpression("new String('123')");
    System.out.println(exp.getValue());

    Role role1 = new Role("员工", "jiu");
    exp = parser.parseExpression("'员工'");
    System.out.println((String) exp.getValue(role1));*/

  }

  @Bean
  public User getUser() {
    User user = new User();
    user.setAge(33);
    user.setName("王五");
    user.setNote("通过Bean注解生成的对象");
    return user;
  }

 /* public Main(@Autowired RoleService roleService){
    this.roleService1 = roleService;
  }*/
}
