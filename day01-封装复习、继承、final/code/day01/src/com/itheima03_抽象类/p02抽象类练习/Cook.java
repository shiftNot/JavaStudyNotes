package com.itheima03_抽象类.p02抽象类练习;

public class Cook extends Employee {
    public Cook() {
    }

    public Cook(String id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        System.out.println("烹饪");
    }
}
