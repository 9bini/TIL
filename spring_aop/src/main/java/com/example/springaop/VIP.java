package com.example.springaop;

import com.example.springaop.aop.AlarmGreetingMachine;

public abstract class VIP {
    public abstract boolean isVIP(User user);
    abstract void visitedBy(User user);
}
