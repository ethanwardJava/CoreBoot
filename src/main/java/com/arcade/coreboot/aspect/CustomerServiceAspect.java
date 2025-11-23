package com.arcade.coreboot.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j2
public class CustomerServiceAspect {

    //TARGET ALL THE METHODS OF SERVICE LAYER
    //TARGET ALL THE METHOD'S OF ALL THE CLASSES INSIDE THE SERVICE METHOD'S WITH ANY PARAMETER
    @Pointcut("execution(* com.arcade.coreboot.service.*.*(..))")
    public void theServiceMethod() {
    }


    @AfterReturning(value = "theServiceMethod()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.warn("The method {} with args {} returned the value {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs(),
                result
        );
    }

    @AfterThrowing(throwing = "throwable", pointcut = "theServiceMethod()")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        log.error(throwable.getMessage(), throwable, joinPoint.getSignature().getName());
    }

    @After("theServiceMethod()") /*For methods with no return like PUT or DELETE */
    public void after(JoinPoint joinPoint) {
        log.info("Method {} executed", joinPoint.getSignature().getName());
    }

}
