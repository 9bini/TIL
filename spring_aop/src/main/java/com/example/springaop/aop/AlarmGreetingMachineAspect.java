package com.example.springaop.aop;

import com.example.springaop.User;
import com.example.springaop.VIP;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AlarmGreetingMachineAspect {

    @Before("@annotation(AlarmGreetingMachine)")
    public void alarm(JoinPoint joinPoint){

        for (Object arg : joinPoint.getArgs()) {
            if ( arg instanceof User){
                User user = (User) arg;
                visitedVIP(joinPoint, user);
                System.out.println(user.getName() + "이(가) 방문했습니다.");
            }
        }

    }

    private void visitedVIP(JoinPoint joinPoint, User user) {
        VIP target = (VIP) joinPoint.getTarget();
        if (target.isVIP(user)){
            System.out.println("VIP 유저 입니다.");
        }
    }
}
