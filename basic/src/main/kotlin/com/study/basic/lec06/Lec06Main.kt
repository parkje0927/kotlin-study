package com.study.basic.lec06

fun main() {

    /**
     * 반복문
     * 1. for-each 문
     * 2. 전통적인 for 문
     * 3. progression, range
     * 4. while
     */
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }

    /**
     * rangeTo 함수 -> IntRange
     * - step 이 1이 기본
     * - IntProgression : 등차수열
     * 사실은 등차수열을 만들어주고 있던 것이다.
     *
     * - downTo, step 도 함수이다.(중위 호출 함수)
     * - 변수.함수이름(argument) 대신 -> 변수 함수이름 argument
     *
     * - step 2 라고 하면 -> 등차수열에 대한 함수 호출해서 등차수열.step(2)
     */
    for (i in 1..3) {
        println(i)
    }

    //3에서 하나씩 내려온다.
    for (i in 3 downTo 1) {
        println(i)
    }

    //2씩 올라간다.
    for (i in 1..5 step 2) {
        println(i)
    }

    //while, do-while 문은 자바와 동일하다.
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }
}