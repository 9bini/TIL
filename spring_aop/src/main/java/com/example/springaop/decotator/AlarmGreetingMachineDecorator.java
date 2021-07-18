package com.example.springaop;

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
