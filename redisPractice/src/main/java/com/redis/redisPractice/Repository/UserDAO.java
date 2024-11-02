package com.redis.redisPractice.Repository;

import com.redis.redisPractice.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserDAO{

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static final String KEY="REDIS_USER";

    public User createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        redisTemplate.opsForHash().put(KEY,user.getUserId(),user);
        return user;
    }

    public Map<Object,Object> getAllUsers(){

       return redisTemplate.opsForHash().entries(KEY);

    }

}
