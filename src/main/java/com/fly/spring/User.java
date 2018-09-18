package com.fly.spring;

import java.util.*;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/3
 */


public class User {
  private String name;
  private int age;
  private String note;
  private List<Role> role;
  private List<String> lists;
  private Set<String> sets;
  private Properties pros;
  private String [] arrays;
  private Map<String , String> maps;
  private Map<Role,User> maps2;

  public Map<Role, User> getMaps2() {
    return maps2;
  }

  public void setMaps2(Map<Role, User> maps2) {
    this.maps2 = maps2;
  }

  public List<String> getLists() {
    return lists;
  }

  public void setLists(List<String> lists) {
    this.lists = lists;
  }

  public Set<String> getSets() {
    return sets;
  }

  public void setSets(Set<String> sets) {
    this.sets = sets;
  }

  public Properties getPros() {
    return pros;
  }

  public void setPros(Properties pros) {
    this.pros = pros;
  }

  public String[] getArrays() {
    return arrays;
  }

  public void setArrays(String[] arrays) {
    this.arrays = arrays;
  }

  public Map<String, String> getMaps() {
    return maps;
  }

  public void setMaps(Map<String, String> maps) {
    this.maps = maps;
  }

  public List<Role> getRole() {
    return role;
  }

  public void setRole(List<Role> role) {
    this.role = role;
  }

  public User(){

  }

  public User(String name, int age, String note, List<Role> role, List<String> lists, Set<String> sets, Properties pros, String[] arrays, Map<String, String> maps) {
    this.name = name;
    this.age = age;
    this.note = note;
    this.role = role;
    this.lists = lists;
    this.sets = sets;
    this.pros = pros;
    this.arrays = arrays;
    this.maps = maps;
  }

  public User(String name, int age, String note, List<Role> role) {
    this.name = name;
    this.age = age;
    this.note = note;
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", note='" + note + '\'' +
      ", role=" + role +
      ", lists=" + lists +
      ", sets=" + sets +
      ", pros=" + pros +
      ", arrays=" + Arrays.toString(arrays) +
      ", maps=" + maps +
      ", maps2=" + maps2 +
      '}';
  }
}
