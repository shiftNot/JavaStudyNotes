package com.itheima03_抽象类.p02抽象类练习;

public class Manager extends Employee {

    public Manager() {
    }

    public Manager(String id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        System.out.println("管理部门");
    }
}