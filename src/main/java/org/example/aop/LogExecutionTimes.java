package org.example.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@ConditionalOnExpression("${aspect.enable:true}")
@Slf4j
public class LogExecutionTimes {

    @Around("@annotation(org.example.aop.ExecutionTimes)")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Class Name: "+
                joinPoint.getSignature().getDeclaringTypeName()
                +". Method Name: "+ joinPoint.getSignature().getName()
                + ". Time taken for Execution is : " + (endTime-startTime) +"ms");
        return obj;
    }
}
