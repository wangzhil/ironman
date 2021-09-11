package com.wzl.common.util.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * redis操作简单封装
 * @author dzz
 * @since  2021年9月10 上午11:44
 * @version 1.0.0
 */
@Service("redisOperations")
public class RedisOperations implements Closeable {

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	/*
	 * 默认超期时间
	 */
	private static final Long TIMEOUT_SECONDS = 60 * 60 * 5L;

    /**
     * 向redis中设置值,不过期.
     * @param key key
     * @param value value
     */
    public void setNoExpire(String key,String value) {
        redisTemplate.boundValueOps(key).set(value);
    }

    /**
     * 向redis中设置值,过期时间默认5小时.
     * @param key key
     * @param value value
     */
	public void set(String key, String value) {
		set(key, value, TIMEOUT_SECONDS);
	}

    /**
     * 向redis中设置值,并指定过期时间.
     * @param key key
     * @param value value
     * @param seconds 过期时间
     */
	public void set(String key, String value, Long seconds) {
		redisTemplate.boundValueOps(key).set(value, seconds, TimeUnit.SECONDS);
	}

    /**
     * 向redis中设置值,如果key不存在则设置成功并返回true.如果key存在则设置失败并返回false
     * @param key key
     * @param value value
     * @return 设置是否成功
     */
    public Boolean setNx(String key, String value) {
		return redisTemplate.boundValueOps(key).setIfAbsent(value);
	}

    /**
     * 向redis中设置Hash数据类型值.
     * @param key key
     * @param fieldName 字段名称
     * @param value 字段值
     */
	public void setHashValue(String key, String fieldName, String value) {
		redisTemplate.boundHashOps(key).put(fieldName, value);
	}

    /**
     * 删除redis中指定key数据.
     * @param key key
     */
	public void delete(String key) {
		redisTemplate.delete(key);
	}

    /**
     * 获取redis中指定key的值.
     * @param key key
     * @return 返回值
     */
	public String get(String key) {
		return redisTemplate.boundValueOps(key).get();
	}

    /**
     * redis原子加1操作
     * @param key key
     * @return 返回值
     */
	public Long incr(String key) {
		return incr(key, 1L);
	}

    /**
     * redis 原子加指定数值操作
     * @param key key
     * @param delta 增加值
     * @return 结果数据
     */
    public Long incr(String key, Long delta) {
		return redisTemplate.boundValueOps(key).increment(delta);
	}

    /**
     * 获取redis中指定key的Hash值
     * @param key key
     * @param fieldName 字段key
     * @return 字段名称
     */
    public Object getHashValue(String key, String fieldName) {
		return redisTemplate.boundHashOps(key).get(fieldName);
	}


	@Override
	public void close() throws IOException {

	}
}
