package com.smz.springbootdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smz.springbootdemo.domain.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableCaching
public class CacheService {
    @Autowired
    private ObjectMapper objectMapper;

    private final RedisTemplate redisTemplate;

    private final StringRedisTemplate stringRedisTemplate;

    public CacheService(RedisTemplate redisTemplate,StringRedisTemplate stringRedisTemplate){
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**simpleBean存储到内容里，涉及到序列化serialVersionUID（无论如何,Bean都带serialVersionUID是否合理？）；
     * key要和配置文件里<key-type>一致
     *
     * @param id 要和配置文件里<value-type>类型对应
     * @return
     */
    @Cacheable(cacheNames = "myCache1", key = "#id", condition = "#id != ''&&#id != null")
    public String queryCache(String id){
        System.out.println("Begin CacheService.querySimpleBean");
        List<String> simpleBeanResult = new ArrayList<>();
        return "simpleBean";
    }

    @CachePut(key = "#key", cacheNames = "myCache1")
    public String save(String key, Object object) throws JsonProcessingException {
        System.out.println("Begin CacheService.save");
        String jsonStr = objectMapper.writeValueAsString(object);
        return jsonStr;
    }

    @CacheEvict(cacheNames = "myCache1")
    public void remove(String id) {
        System.out.println("Begin CacheService.remove");
    }
}
