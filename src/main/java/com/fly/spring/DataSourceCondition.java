package com.fly.spring;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author : SongYF
 * @desc : 加载 Bean 的条件，返回true则加载，false则不加载
 * @date : 2018/9/7
 */


public class DataSourceCondition implements Condition {
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
    Environment env = conditionContext.getEnvironment();
    Boolean result =  env.containsProperty("driver")&&env.containsProperty("url")&&env.containsProperty("username")&&env.containsProperty("password");
    return result;
  }
}
