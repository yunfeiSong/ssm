package com.fly.webApplication;

/**
 * @Desc : 注解方式配置 web 应用中的 spring IOC 和 spring MVC
 * @Author : SongYF
 * @Date : 2018/9/20 14:31
 */


public class MyWebAppInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {
  /**
   *  spring IOC 容器配置
   */
  protected Class<?>[] getRootConfigClasses() {
    //可以返回 spring 的 java 配置文件数组
    return new Class[]{WebConfig.class};
  }

  /**
   * DispatcherServlet 的 URI 映射关系配置
   */
  protected Class<?>[] getServletConfigClasses() {
    //可以返回 spring 的 java 配置文件数组
    return new Class[] {WebConfig.class};
  }

  /**
   * DispatcherServlet 拦截内容
   */
  protected String[] getServletMappings() {

    return new String[] {"*.do"};
  }
}
