package com.example.springaop;

// Real Subject Object
public class GreetingMachine implements IGreetingMachine{
    @Override
    public void greet(User user) {
        // 핵심
        System.out.println("어서 오세요!");
    }
}
