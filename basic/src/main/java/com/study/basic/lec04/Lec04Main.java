package com.study.basic.lec04;

import com.study.basic.domain.JavaMoney;

public class Lec04Main {

    public static void main(String[] args) {
        JavaMoney money1 = new JavaMoney(2_000L);
        JavaMoney money2 = new JavaMoney(1_000L);

        if (money1.compareTo(money2) > 0) {
            System.out.println("Money1 이 Money2 보다 크다.");
        }

        money1 = new JavaMoney(1_000L);
        money2 = money1;
        JavaMoney money3 = new JavaMoney(1_000L);

        System.out.println(money1 == money2); //true
        System.out.println(money1 == money3); //false
        System.out.println(money1.equals(money3)); //true
    }
}
