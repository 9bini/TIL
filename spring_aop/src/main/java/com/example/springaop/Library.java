package com.example.springaop;

import com.example.springaop.aop.AlarmGreetingMachine;
import org.springframework.stereotype.Component;

@Component
public class Library extends VIP {
    private String name;

    private int visitCountByUser = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisitCountByUser(int visitCountByUser) {
        this.visitCountByUser = visitCountByUser;
    }

    @Override
    public boolean isVIP(User user) {
        return visitCountByUser > 10;
    }

    @Override
    @AlarmGreetingMachine
    public void visitedBy(User user) {
        System.out.println("환영합니다." + this.name + " 입니다.");
    }
}
