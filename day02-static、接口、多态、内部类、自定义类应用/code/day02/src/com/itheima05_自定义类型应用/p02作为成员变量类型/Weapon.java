package com.itheima05_自定义类型应用.p02作为成员变量类型;

public class Weapon {
    private String name;

    public Weapon() {
    }

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println("一刀999");
    }
}
