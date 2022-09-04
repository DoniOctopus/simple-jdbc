package com.mandiri.models;

public class Hero {
    public String name;
    public static Integer hp;

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }

    public Hero(String name, Integer hp) {
        this.name = name;
        this.hp = hp;
    }
}
