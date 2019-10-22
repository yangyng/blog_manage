package com.yangy.manage.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 *
 * @author yang yang
 * @email yangy_0329@163.com
 * @create 2019/1/4
 */
@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    private ValueOperations<String, String> valueOperations;

    public void RedisUtils(){
        this.valueOperations = redisTemplate.opsForValue();
    }

    public static final long DEFAULT_EXPIRE_SECONDS = 24 * 60 * 60;

    public static final long ZERO_EXPIRE_SECONDS = 0;

    public static final long NO_EXPIRE_SECONDS = -1;

    public void set(String key, Object value, long expire) {
        valueOperations.set(key, JSON.toJSONString(value));
        if (expire != NO_EXPIRE_SECONDS) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE_SECONDS);
    }

    public <AnyType> AnyType get(String key, Class<AnyType> clazz) {
        AnyType object = null;
        String json = valueOperations.get(key);
        if (StringUtils.isNotEmpty(json)) {
            object = JSON.parseObject(json, clazz);
        }
        return object;
    }

    public String get(String key) {
        String json = valueOperations.get(key);
        return null == json ? "" : json;
    }

    public void delete(String key) {
        redisTemplate.expire(key, ZERO_EXPIRE_SECONDS, TimeUnit.SECONDS);
    }
}
