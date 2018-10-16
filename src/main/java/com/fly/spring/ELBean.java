package com.fly.spring;

import com.fly.mybatis.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : SongYF
 * @desc : 测试 EL 表达式及引用外部 bean
 * @date : 2018/9/10
 */

@Component("eLBean")
public class ELBean {

  @Value("#{role}") // EL 表达式注入 bean
  private Role role;

  //@Value("#{role.getName()?.toString()}") // EL 表达式注入方法,? 号，表示判断是否为空，是就调用toString（） 方法
  //@Value("#{role.getName() eq null ? '默认': role.getName()}") //EL 中可以使用三目运算符
  private String name;

  @Value("#{T(Math).PI}") // 调用静态变量或静态方法 需加 T()
  private double pi;

  @Value("#{T(Math).random()}")
  private double random;

  //@Value("#{role.getName()+role.getLev()}") // EL 中允许使用 + 进行拼接 ，同时可进行 运算和比较大小
  private String toString;

  //@Value("#{'董事长' eq role.getName()}") // 比较相等可以使用 eq 或 ==
  //@Value("#{'董事长' == role.getName()}")
  private boolean eq;

  @Override
  public String toString() {
    return "ELBean{" +
      "role=" + role +
      ", name='" + name + '\'' +
      ", pi=" + pi +
      ", random=" + random +
      ", toString='" + toString + '\'' +
      ", eq=" + eq +
      '}';
  }

  public boolean isEq() {
    return eq;
  }

  public void setEq(boolean eq) {
    this.eq = eq;
  }

  public String getToString() {
    return toString;
  }

  public void setToString(String toString) {
    this.toString = toString;
  }

  public double getRandom() {
    return random;
  }

  public void setRandom(double random) {
    this.random = random;
  }

  public double getPi() {
    return pi;
  }

  public void setPi(double pi) {
    this.pi = pi;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
