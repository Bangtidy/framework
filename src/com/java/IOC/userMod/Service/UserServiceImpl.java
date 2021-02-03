package com.java.IOC.userMod.Service;

import com.java.IOC.userMod.dao.UserDao;
import com.java.IOC.userMod.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

    public UserServiceImpl(){
        System.out.println("UserServiceImpl");
    }

    @Override
    public void addUser() {
        userDao.addUser();
    }
}
