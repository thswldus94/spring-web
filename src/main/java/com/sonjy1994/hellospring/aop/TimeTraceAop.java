package com.sonjy1994.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {

    // 적용할 범위 지정
    // @Around("execution(* com.sonjy1994.hellospring..*(..))")
    // Bean 으로 등록 시 spring config도 aop로 순환 참조가 되버리므로 에러발생함
    // 발생 안하도록 타켓 예외 처리를 해줘야 함
    // 여기에 Component으로 등록할때는 문제없음
    @Around("execution(* com.sonjy1994.hellospring..*(..)) && !target(com.sonjy1994.hellospring.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
