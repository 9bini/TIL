package com.example.springaop;

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
