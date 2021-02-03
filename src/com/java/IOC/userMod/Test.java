package com.java.IOC.userMod;

import com.java.IOC.userMod.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("user.xml");
        UserController userController = (UserController) applicationContext.getBean("aaa",UserController.class);
        System.out.println(userController);
        userController.addUser();
    }

}
