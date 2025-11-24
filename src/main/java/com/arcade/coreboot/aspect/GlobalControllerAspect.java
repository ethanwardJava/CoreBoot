package com.arcade.coreboot.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j2
@RequiredArgsConstructor
public class GlobalControllerAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void restControllers() {
    }

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void mvcControllerMethods() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void controllerHandlers() {
    }


    @Around("controllerHandlers()")
    public Object aroundMapping(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Calling handler: {}", pjp.getSignature());
        return pjp.proceed();
    }


    @AfterReturning(value = "restControllers() || mvcControllerMethods()")
    public void afterReturning(JoinPoint joinPoint) {
        log.warn("Calling {} with args {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs()
        );
    }

    @AfterThrowing(throwing = "throwable", pointcut = "restControllers() || mvcControllerMethods()")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        log.error(throwable.getMessage(), throwable, joinPoint.getSignature().getName());
    }

    @After("restControllers() || mvcControllerMethods()")
    public void after(JoinPoint joinPoint) {
        log.info("Calling method {}", joinPoint.getSignature().getName());
    }
}
