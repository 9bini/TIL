package com.example.springaop.decotator;

import com.example.springaop.IGreetingMachine;
import com.example.springaop.User;

public class AlarmGreetingMachineDecorator extends GreetingMachineDecorator {
    public AlarmGreetingMachineDecorator(IGreetingMachine greetingMachine) {
        super(greetingMachine);
    }

    @Override
    public void greet(User user) {

        // 부가 기능
        alarm(user);

        // 핵심 기능
        greetingMachine.greet(user);
    }

    private void alarm(User user) {
        System.out.println(user.getName() + "님이 방문했습니다.");
    }
}
