package com.fly.mybatis;

import java.util.Date;

/**
 * @Desc : 存储过程结果类
 * @Author : SongYF
 * @Date : 2018/9/13 16:33
 * @Copyright (c) 2015 jigoon
 */


public class RoleCountResult {

  private String note;
  private int countTotal;
  private Date execDate;

  @Override
  public String toString() {
    return "RoleCountResult{" +
      "note='" + note + '\'' +
      ", countTotal=" + countTotal +
      ", execDate=" + execDate +
      '}';
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public int getCountTotal() {
    return countTotal;
  }

  public void setCountTotal(int countTotal) {
    this.countTotal = countTotal;
  }

  public Date getExecDate() {
    return execDate;
  }

  public void setExecDate(Date execDate) {
    this.execDate = execDate;
  }
}
