package com.zzl.gc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author luotao
 * @Package com.zzl.gc.util
 * @date 2019/8/26 12:50
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public long ttl(String key) {
        /**
         * @author luotao
         * @date 2019/8/26 17:33
         * @param key
         * @return long
         * @describe 实现命令：TTL key，以秒为单位，返回给定 key的剩余生存时间(TTL, time to live)。
         */
        return redisTemplate.getExpire(key);
    }

    public void expire(String key, long timeout) {
        /**
         * @author luotao
         * @date 2019/8/26 17:34
         * @param key
         * @param timeout
         * @return void
         * @describe 实现命令：expire 设置过期时间，单位秒
         */
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public long incr(String key, long delta) {
        /**
         * @author luotao
         * @date 2019/8/26 17:35
         * @param key
         * @param delta
         * @return long
         * @describe 实现命令：INCR key，增加key一次
         */
        return redisTemplate.opsForValue().increment(key, delta);
    }

    public long decr(String key, long delta) {
        /**
         * @author luotao
         * @date 2019/8/26 17:38
         * @param key
         * @param delta
         * @return long
         * @describe 实现命令： key，减少key一次
         */
        if(delta<0){
            //throw new RuntimeException("递减因子必须大于0");
            del(key);
            return 0;
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    public Set<String> keys(String pattern) {
        /**
         * @author luotao
         * @date 2019/8/26 17:39
         * @param pattern
         * @return java.util.Set<java.lang.String>
         * @describe 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
         */
        return redisTemplate.keys(pattern);
    }

    public void del(String key) {
        /**
         * @author luotao
         * @date 2019/8/26 17:39
         * @param key
         * @return void
         * @describe 实现命令：DEL key，删除一个key
         */
        redisTemplate.delete(key);
    }

    public void set(String key, String value) {
        /**
         * @author luotao
         * @date 2019/8/26 17:40
         * @param key
         * @param value
         * @return void
         * @describe 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
         */
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, long timeout) {
        /**
         * @author luotao
         * @date 2019/8/26 17:40
         * @param key
         * @param value
         * @param timeout 单位为秒
         * @return void
         * @describe 实现命令：SET key value EX seconds，设置key-value和超时时间（秒）
         */
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public String get(String key) {
     /**
     * @author luotao
     * @date 2019/8/26 17:41
     * @param key
     * @return java.lang.String
     * @describe 实现命令：GET key，返回 key所关联的字符串值。
     */
        return (String) redisTemplate.opsForValue().get(key);
    }

    public void hset(String key, String field, Object value) {
        /**
         * @author luotao
         * @date 2019/8/26 17:41
         * @param key
         * @param field
         * @param value
         * @return void
         * @describe 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
         */
        redisTemplate.opsForHash().put(key, field, value);
    }

    public String hget(String key, String field) {
        /**
         * @author luotao
         * @date 2019/8/26 17:45
         * @param key
         * @param field
         * @return java.lang.String
         * @describe 实现命令：HGET key field，返回哈希表 key中给定域 field的值
         */
        return (String) redisTemplate.opsForHash().get(key, field);
    }

    public void hdel(String key, Object... fields) {
        /**
         * @author luotao
         * @date 2019/8/26 17:45
         * @param key
         * @param fields
         * @return void
         * @describe 实现命令：HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
         */
        redisTemplate.opsForHash().delete(key, fields);
    }

    public Map<Object, Object> hgetall(String key) {
        /**
         * @author luotao
         * @date 2019/8/26 17:45
         * @param key
         * @return java.util.Map<java.lang.Object,java.lang.Object>
         * @describe 实现命令：HGETALL key，返回哈希表 key中，所有的域和值。
         */
        return redisTemplate.opsForHash().entries(key);
    }

    public long lpush(String key, String value) {
        /**
         * @author luotao
         * @date 2019/8/26 17:46
         * @param key
         * @param value
         * @return long
         * @describe 实现命令：LPUSH key value，将一个值 value插入到列表 key的表头
         */
        return redisTemplate.opsForList().leftPush(key, value);
    }

    public String lpop(String key) {
        /**
         * @author luotao
         * @date 2019/8/26 17:46
         * @param key
         * @return java.lang.String
         * @describe 实现命令：LPOP key，移除并返回列表 key的头元素。
         */
        return (String) redisTemplate.opsForList().leftPop(key);
    }

    public long rpush(String key, String value) {
        /**
         * @author luotao
         * @date 2019/8/26 17:46
         * @param key
         * @param value
         * @return long  LPUSH命令后，列表的长度。
         * @describe 实现命令：RPUSH key value，将一个值 value插入到列表 key的表尾(最右边)。
         */
        return redisTemplate.opsForList().rightPush(key, value);
    }
}
