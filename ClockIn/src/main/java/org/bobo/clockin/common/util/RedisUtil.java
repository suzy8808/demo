package org.bobo.clockin.common.util;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtil {
//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;
//
//    public void set(String key, Object value) {
//        // 更改在redis里面查看key编码问题
//        @SuppressWarnings("rawtypes")
//        RedisSerializer redisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
//        vo.set(key, value);
//    }
//
//    public Object get(String key) {
//        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
//        return vo.get(key);
//    }
}
