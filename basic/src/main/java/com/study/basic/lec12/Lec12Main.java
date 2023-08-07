package com.study.basic.lec12;

public class Lec12Main {

    public static void main(String[] args) {
        moveSomething(new Movable() {

            @Override
            public void move() {
                System.out.println("move");
            }

            @Override
            public void fly() {
                System.out.println("fly");
            }
        });
    }

    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }
}
