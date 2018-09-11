package com.fly.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author : SongYF
 * @desc : 鉴别器实现类
 * @date : 2018/9/11
 * @Copyright (c) 2015 jigoon
 */

@Component
public class RoleVerifierImpl implements RoleVerifier {

  public Boolean verify(Role role) {
    return role != null;
  }
}
