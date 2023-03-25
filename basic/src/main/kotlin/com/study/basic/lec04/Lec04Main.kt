package com.study.basic.lec04

import com.study.basic.domain.JavaMoney
import com.study.basic.domain.KotlinMoney

fun main() {

    /**
     * java
     * - 객체간의 비교는 compareTo
     * - 인터페이스를 구현
     * -> if (money1.compareTo(money2) > 0) {}
     *
     * kotlin
     * - java 와 다르게 객체를 비교할 때 비교 연산자를 사용하면 자동으로 compareTo 를 호출해준다.
     */

    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if (money1 > money2) {
        println("Money1 가 Money2 보다 크다.")
    }

    /**
     * - 동등성(equality) : 두 객체의 값이 같은가?
     * - 동일성(identity) : 완전히 동일한 객체인가? 즉 주소가 같은가?
     *
     * java
     * - 동등성에는 equals, 동일성에는 ==
     *
     * kotlin
     * - 동등성에는 ==, 동일성에는 ===
     */
    val money3 = JavaMoney(1_000L)
    val money4 = money3
    val money5 = JavaMoney(1_000L)

    println(money3 === money4) //true
    println(money3 === money5) //false
    println(money3 == money5) //true

    /**
     * 논리 연산자 : &&, ||, !
     * - java 와 완전히 동일하다.
     * - java 처럼 Lazy 연산을 수행한다.
     * - lazy 연산이란, 아래 두 fun1, fun2 함수가 있을 때 fun1() || fun2() 의 조건이 주어지면
     * fun2() 를 호출하지 않고 바로 본문이 실행되는 것을 의미한다.
     */

    if (fun1() || fun2()) {
        println("본문")
    }

    /**
     * in, !in
     * - 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다.
     *
     * a..b
     * - a 부터 b 까지의 범위 객체를 생성한다.
     *
     * a[i]
     * - a 에서 특정 index i 로 값을 가져온다.
     *
     * a[i] = b
     * - a 의 특정 index 에 값을 넣는다.
     */

    /**
     * 연산자 오버로딩
     * - 객체마다 연산자를 직접 정의할 수 있다.
     */
    val money6 = KotlinMoney(1_000L)
    val money7 = KotlinMoney(2_000L)
    println(money6 + money7) //operator fun plus 가 수행되는 것이다.
}

fun fun1(): Boolean {
    println("fun 1")
    return true
}

fun fun2(): Boolean {
    println("fun 2")
    return false
}