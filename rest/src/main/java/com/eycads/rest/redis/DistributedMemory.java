package com.eycads.rest.redis;

public interface DistributedMemory {

  public void set(String key, String value);

  public String get(String key);

}
