package ru.geekbrains.js_spring_market.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {

    private Long cartTime;
    private Long bookTime;

    public Long getCartTime() {
        return cartTime;
    }

    public Long getBookTime() {
        return bookTime;
    }

    @Around("execution(public * ru.geekbrains.js_spring_market.service.BookService.*(..))")
    public Object bookServiceMethodsProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long stop = System.currentTimeMillis();
        bookTime = stop - start;
        //System.out.println("Время выполнения всех методов сервиса BookService:" + bookTime);
        return out;
    }

    @Around("execution(public * ru.geekbrains.js_spring_market.service.CartService.*(..))")
    public Object cartServiceMethodsProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long stop = System.currentTimeMillis();
        cartTime = stop - start;
        //System.out.println("Время выполнения всех методов сервиса BookService:" + cartTime);
        return out;
    }
}
