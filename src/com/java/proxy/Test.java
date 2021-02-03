package com.java.proxy;

public class Test {

    public static void main(String[] args) {
        /*MathI mathI = new MathImpl();
        int result = mathI.add(1,1);
        System.out.println(result);*/
        ProxyUtil proxyUtil = new ProxyUtil(new MathImpl());
        MathI mathI = (MathI) proxyUtil.getProxy();
        int i = mathI.div(4, 2);
        System.out.println(i);
    }

}
