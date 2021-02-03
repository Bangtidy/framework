package com.java.IOC.userMod.controller;

import com.java.IOC.userMod.Service.UserService;
import com.java.IOC.userMod.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.naming.Name;

@Controller(value = "aaa")
public class UserController {

    @Autowired//自动装配
    private UserService userService;

    public void addUser(){
        userService.addUser();
    }

    public UserController(){

        System.out.println("UserController");

    }

}
