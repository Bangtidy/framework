package com.java.IOC.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("datasource.xml");
        DruidDataSource datasource = applicationContext.getBean("datasource", DruidDataSource.class);
        System.out.println(datasource.getConnection());
    }
}
