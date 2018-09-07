package com.fly.spring;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/9/7
 * @Copyright (c) 2015 jigoon
 */


public class DataSourceCondition implements Condition {
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
    Environment env = conditionContext.getEnvironment();
    Boolean result =  env.containsProperty("driverClassName")&&env.containsProperty("url")&&env.containsProperty("username")&&env.containsProperty("password");
    return result;
  }
}
