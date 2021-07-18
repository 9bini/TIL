package com.example.springaop.decotator;

import com.example.springaop.IGreetingMachine;
import com.example.springaop.User;

public class DancingGreetingMachineDecorator extends GreetingMachineDecorator{
    public DancingGreetingMachineDecorator(IGreetingMachine greetingMachine) {
        super(greetingMachine);
    }

    @Override
    public void greet(User user) {
        dancing();
        greetingMachine.greet(user);

    }

    private void dancing() {
        System.out.println("춤 추는 중");
    }
}
