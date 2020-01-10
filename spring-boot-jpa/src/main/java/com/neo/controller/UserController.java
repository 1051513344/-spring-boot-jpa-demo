package com.neo.controller;

import com.neo.model.User;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> all(){
        return userService.getAllUser();
    }

    @GetMapping("/getUserByExample")
    public User userByExample(){
        return userService.getUserByExample();
    }

    @GetMapping("/getAllUserByPage")
    public List<User> userByPage(){
        return userService.getAllUserByPage();
    }

    @GetMapping("/getUserByLessId")
    public List<User> userByLessId(@RequestParam("maxId") Long maxId){
        return userService.getUserByLessId(maxId);
    }

    @GetMapping("/getAllUserByMaxId")
    public List<User> userByMaxId(){
        return userService.getUserByMaxId();
    }

    @GetMapping("/updateUserNameById")
    public User updateUserName(@RequestParam("id") Long id){
        userService.updateUserNameById(id);
        return userService.getUserById(id);
    }


}

