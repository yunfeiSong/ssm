package com.fly.redis;

import com.fly.mybatis.Role;
import com.fly.mybatis.RoleEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * @Desc : Java 中使用 Redis
 * @Author : SongYF
 * @Date : 2018/10/8 11:02
 * <p>
 * <p>
 * redis 的六种数据类型：
 * 1、String      字符串
 * 2、hash        哈希结构
 * 3、list        列表
 * 4、set         集合
 * 5、zset        有序集合
 * 6、HyperLogLog 基数
 */
public class Main {

  private RedisTemplate redisTemplate;

  private ApplicationContext applicationContext;

  {
    applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
  }

  public static void main(String[] args) {

    new Main().useRedisSUbAndPUb();
  }

  /**
   * redis 发布订阅 java 实现
   */
  public void useRedisSUbAndPUb() {
    redisTemplate.convertAndSend("chat", "redis subscribe and publish 发布订阅模式");//像指定渠道发送消息
  }

  /**
   * 使用 redis 的 pipelined 流水线技术，提高系统性能，加快读写速度
   */
  public void useRedisPipeline() {
    Jedis jedis = new Jedis("localhost", 6379);

    long start = System.currentTimeMillis();

    Pipeline pipeline = jedis.pipelined();

    for (int i = 0; i < 100000; i++) {
      int j = i + 1;
      pipeline.set("pipeline" + j, j + "");
      pipeline.get("pipeline" + j);
    }

    //pipeline.sync(); //不返回结果
    List<Object> result = pipeline.syncAndReturnAll();//返回结果，注意的是，返回结果过大时会严重占用内存，可能会造成内存溢出

    long end = System.currentTimeMillis();

    System.out.println("十万次读写，耗时" + (end - start) + "毫秒");
  }

  /**
   * 使用 spring 的 redisTemplate 保存 java 对象
   */
  public void useRedisTemplate() {

    final Role role = new Role();
    role.setId(1111);
    role.setRoleEnum(RoleEnum.Employee);
    role.setNote("测试 redis 存储 java 对象");

//    redisTemplate.opsForValue().set("role_1" , role);
//
//    Role role_1 = (Role) redisTemplate.opsForValue().get("role_1");

    SessionCallback callback = new SessionCallback<Role>() {//匿名类确保每次的 set 和 get 为连接池中的同一连接

      public Role execute(RedisOperations redisOperations) throws DataAccessException {

        redisOperations.watch("role_2");

        /*
         * watch 在exec（） 时会校验，watch 的键所对应的值是否改变，未改变则提交，改变则回滚
         *
         * redis 的事务类似于 乐观锁机制，但是不存在 ABA 问题
         *
         * ABA问题：一个线程修改了值，在提交前又修改回了原值，在提交前比对时，则会产生未被修改过的假象，实际上，整个过程中可能已经影响了其他线程的结果
         */


        redisOperations.multi();//开启 redis 事务

        redisOperations.boundValueOps("role_2").set(role);

        redisOperations.exec();//执行，返回事务中所有 redis 命令的结果

//        redisOperations.discard();//回滚   命令出现错误所有命令都会回滚，数据类型错误，则该命令不会执行，其余命令正常执行

        return (Role) redisOperations.boundValueOps("role_2").get();
      }
    };
    Role role_2 = (Role) redisTemplate.execute(callback);

    //redisTemplate.executePipelined(callback); redisTemplate 使用 pipelined 流水线技术

    System.out.println(role_2.getNote());

  }

  /**
   * redis 单连接和连接池
   * 测试 redis 每秒写入速度
   */
  public void getjedisPoolConfig() {
    //Jedis jedis = new Jedis("localhost", 6379);//建立单个连接

    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();//连接池配置
    jedisPoolConfig.setMaxIdle(50);//最大空闲数
    jedisPoolConfig.setMaxTotal(100);//最大连接数
    jedisPoolConfig.setMaxWaitMillis(20000);//最大等待时长（毫秒）

    JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost");//创建连接池
    Jedis jedisFromPool = jedisPool.getResource();//获取单个连接

    //jedis.auth("123456");//设置密码，如果有的话

    int i = 0;
    try {
      Long startTime = System.currentTimeMillis();
      while (true) {
        Long endTime = System.currentTimeMillis();
        if (endTime - startTime >= 1000) {
          break;
        }
        i++;
        jedisFromPool.set("test" + i, i + "");//写入 redis
      }
    } finally {
      jedisFromPool.close();//关闭连接
    }

    System.out.println("每秒操作" + i + "次");
  }

}
