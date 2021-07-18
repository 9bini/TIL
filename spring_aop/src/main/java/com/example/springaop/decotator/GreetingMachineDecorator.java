package com.example.springaop.decotator;

import com.example.springaop.IGreetingMachine;

public abstract class GreetingMachineDecorator implements IGreetingMachine {
    protected IGreetingMachine greetingMachine;

    public GreetingMachineDecorator(IGreetingMachine greetingMachine) {
        this.greetingMachine = greetingMachine;
    }
}
