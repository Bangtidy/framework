package com.java.proxy;

public class MyLogger {

    public static void before(String methodName,Object args){
        System.out.println("method:"+methodName+",arguments:"+args);
    }

    public static void after(String methodName,Object args){
        System.out.println("method:"+methodName+",result:"+args);
    }

    public static void thorwsing(){
        System.out.println("发现异常");
    }

}
