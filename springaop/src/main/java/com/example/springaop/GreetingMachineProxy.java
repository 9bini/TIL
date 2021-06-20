package com.example.springaop;

// Proxy Object
public class GreetingMachineProxy implements IGreetingMachine {
    private GreetingMachine greetingMachine;

    public GreetingMachineProxy() {
        this.greetingMachine = new GreetingMachine();
    }

    @Override
    public void greet(User user) {

        // 부가
        System.out.println(user.getName() + "님이 방문했습니다.");

        greetingMachine.greet(user);

    }
}
