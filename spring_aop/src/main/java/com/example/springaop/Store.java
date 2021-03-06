package com.example.springaop;

import com.example.springaop.aop.AlarmGreetingMachine;
import org.springframework.stereotype.Component;

@Component
public class Store extends VIP{
    private String name;

    private int visitCountByUser = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void setVisitCountByUser(int visitCountByUser) {
        this.visitCountByUser = visitCountByUser;
    }

    public String getOperationTime() {
        return "AM 08:00 ~ PM 08:00";
    }


    @Override
    public boolean isVIP(User user) {
        return visitCountByUser > 10;
    }


    @Override
    @AlarmGreetingMachine
    public void visitedBy(User user) {
        greeting();
    }



    private void greeting() {
        System.out.println("어서오세요");
    }
}
