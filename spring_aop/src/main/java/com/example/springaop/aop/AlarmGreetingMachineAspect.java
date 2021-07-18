package com.example.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AlarmGreetingMachineAspect {

    @Before("@annotation(AlarmGreetingMachine)")
    public void alarm(JoinPoint joinPoint){
        joinPoint.getTarget()

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if ( arg instanceof User){
                User user = (User) arg;
                System.out.println(user.getName() + "이(가) 방문했습니다.");
            }
        }

    }
}
