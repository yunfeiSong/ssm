package com.fly.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Desc : 发布订阅监听类
 * @Author : SongYF
 * @Date : 2018/10/8 17:14
 */
public class RedisMessageListener implements MessageListener {

  private RedisTemplate redisTemplate;

  public RedisTemplate getRedisTemplate() {
    return redisTemplate;
  }

  public void setRedisTemplate(RedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void onMessage(Message message, byte[] bytes) {
    byte[] body = message.getBody();//消息主体
    String msgBody = (String) getRedisTemplate().getValueSerializer().deserialize(body);
    System.err.println(msgBody);

    byte[] channel = message.getChannel();//渠道
    String msgChannel = (String) getRedisTemplate().getStringSerializer().deserialize(channel);
    System.err.println(msgChannel);

    String bytesStr = new String(bytes);//字节数组形式的渠道名
    System.err.println(bytesStr);

  }
}
