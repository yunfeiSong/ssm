package com.fly.spring.aop;

/**
 * @author : SongYF
 * @desc : 鉴别器-判断是否为null
 * @date : 2018/9/11
 * @Copyright (c) 2015 jigoon
 */
public interface RoleVerifier {

  public Boolean verify(Role role);
}
