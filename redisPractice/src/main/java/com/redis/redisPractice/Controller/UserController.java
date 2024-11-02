package com.redis.redisPractice.Controller;

import com.redis.redisPractice.Models.User;
import com.redis.redisPractice.Repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("redis/practice/user")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userDAO.createUser(user);
    }

    @GetMapping
    public Map<Object,Object> getAllUsers(){
        return userDAO.getAllUsers();
    }
}
