package com.sk.eadmin.config;

import java.lang.reflect.Parameter;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class MethodLogger {
  @Pointcut("execution(* com.sk.eadmin.biz..*.*(..))")
  private void cut(){}

  @Before("cut()")
  public void beforeParameterLog(JoinPoint joinPoint) {
    final Parameter[] parameters = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameters();
    final Object[] args = joinPoint.getArgs();
    log.debug("----> {}#{}\n{}",
      ((MethodSignature)joinPoint.getSignature()).getMethod().getDeclaringClass().getName(),
      ((MethodSignature)joinPoint.getSignature()).getMethod().getName(),
      IntStream.range(0, parameters.length)
        .mapToObj(
          index -> "    parameters "
            + parameters[index].getName()
            + "["
            + Optional.ofNullable(args[index]).map(arg -> arg.toString()).orElse(null)
            + "]"
        )
        .collect(Collectors.joining("\n"))
    );
  }

  @AfterReturning(value = "cut()", returning = "returnObj")
  public void afterReturnLog(JoinPoint joinPoint, Object returnObj) {
    log.debug("<---- {}#{}\n",
      ((MethodSignature)joinPoint.getSignature()).getMethod().getDeclaringClass().getName(),
      ((MethodSignature)joinPoint.getSignature()).getMethod().getName(),
      "    return[" + Optional.ofNullable(returnObj).map(_returnObj -> _returnObj.toString()).orElse(null) + "]"
    );
  }
}