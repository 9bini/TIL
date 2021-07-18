package com.example.springaop;

public class User {

    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String greetring() {
        return "Hello";
    }

    public void visitTo(VIP vip){
        vip.visitedBy(this);
    }

}