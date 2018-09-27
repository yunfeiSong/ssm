package com.fly.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Desc : 自定义拦截器
 * @Author : SongYF
 * @Date : 2018/9/27 10:53
 */

/*
  自定义拦截器必须实现 HandlerInterceptor 接口 ， 也可以继承 HandlerInterceptorAdapter 抽象类
 */
public class RoleInterceptor implements HandlerInterceptor {

  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    System.out.println("preHandle");
    return true;//返回 false 则接下来的控制器代码不再执行
  }

  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    System.out.println("postHandle");
  }

  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    System.out.println("afterCompletion");
  }
}
