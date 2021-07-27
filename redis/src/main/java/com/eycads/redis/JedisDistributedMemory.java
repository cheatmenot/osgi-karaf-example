package com.eycads.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;

public class JedisDistributedMemory implements DistributedMemory {

  private final Jedis jedis;

  public JedisDistributedMemory(String host, int port){
    this.jedis = new Jedis(host, port);
  }

  public JedisDistributedMemory(HostAndPort hostAndPort){
    this.jedis = new Jedis(hostAndPort);
  }

  public JedisDistributedMemory(HostAndPort hostAndPort, JedisClientConfig config){
    this.jedis = new Jedis(hostAndPort, config);
  }

  @Override
  public void set(String key, String value) {
    jedis.set(key, value);
  }

  @Override
  public String get(String key) {
    return jedis.get(key);
  }

}
