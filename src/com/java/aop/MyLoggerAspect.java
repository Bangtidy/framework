package com.java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect//标注当前类为切面
public class MyLoggerAspect {
    //通知

    /**
     * @Before：将方法指定为前置通知
     * 必须设置value,其值为切入点表达式
     */
    @Before(value = "execution(* com.java.aop.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();//获取参数
        String name = joinPoint.getSignature().getName();//获取方法名
        System.out.println("method:"+name+",arguments:"+ Arrays.toString(args));
    }

    /**
     * @After：将方法标志为后置通知
     * 后置通知：作用于方法的finally语句块，即 不管有没有异常都会执行
     *
     */
    @After(value = "execution(* com.java.aop.*.*(..))")
    public void afterMethod() {
        System.out.println("后置通知");
    }

    /**
     * @AfterReturning:将方法标注为返回通知
     * 返回通知：作用于方法执行之后
     * 可通过returning设置接收方法返回值的变量名
     * 想要在方法中使用，必须在方法的形参中设置和变量名的参数
     * @param joinPoint
     */
    @AfterReturning(value = "execution(* com.java.aop.*.*(..))",returning="result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("method:"+name+",result:"+result);
    }

    /**
     * @AfterThrowing:将方法标注为异常通知（例外通知）
     * 异常通知（例外通知）：作用于方法抛出异常时
     * 可通过throwing设置接收方法返回的异常信息
     * 在参数列表中可通过具体的异常类型，来对指定的异常信息进行操作
     * @param ex
     */
    @AfterThrowing(value = "execution(* com.java.aop.*.*(..))",throwing = "ex")
    public void afterThrowing(ArithmeticException ex){
        System.out.println("有异常了,message:"+ex);
    }

    @Around(value = "execution(* com.java.aop.*.*(..))")
    public Object aroudMethod(ProceedingJoinPoint proceedingJoinPoint){

        Object result = null;

        try {
            //前置通知
            System.out.println("前置通知");
            result = proceedingJoinPoint.proceed();//执行方法
            // 返回通知
            System.out.println("返回通知");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //异常通知
            System.out.println("异常通知");
        }finally {
            //后置通知
            System.out.println("后置通知");
        }
        return -1;
    }

}
