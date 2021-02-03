package com.java.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        MathI mathI = applicationContext.getBean("mathImpl",MathI.class);
        int result = mathI.div(4, 1 );
        System.out.println(result);
    }

}
