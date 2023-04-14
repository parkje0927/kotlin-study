package com.study.basic.lec08

fun main() {

    /**
     * 1. 함수 선언 문법
     * 2. default parameter
     * 3. named argument(parameter)
     * 4. 같은 타입의 여러 파라미터 받기(가변인자)
     */

    /**
     * 함수는 클래스 안에 있을 수도, 파일 최상단에 있을 수도 있다.
     * 또한 한 파일 안에 여러 함수들이 있을 수도 있다.
     */

    max(3, 5)

    repeat("Hello World")
    repeat("Hello World", 3, true)
    repeat("Hello World", 5, true)

    //named argument(parameter)
    //매개변수 이름을 통해 직접 지정하고, 지정되지 않은 매개변수는 기본값 사용
    //builder 를 직접 만들지 않고, builder 의 장점을 가지게 된다.
    //but, java 함수를 가져다 쓸 때는 named argument 를 쓸 수 없다.
    repeat("Hello World", useNewLine = false)
    printNameAndGender(name = "park", gender = "female") //순서 바꿔쓰는 실수를 방지해준다.

    //같은 타입의 여러 파라미터 받기(가변인자)
    printAll("A", "B", "C")

    var array = arrayOf("A", "B", "C")
    printAll(*array)
}

//함수 선언 문법
//fun max(a: Int, b: Int): Int =
//    if (a > b) {
//        a
//    } else {
//        b
//    }

//= 을 써서 반환 타입을 생략했다.
fun max(a: Int, b: Int) = if (a > b) a else b

//default parameter
//자바에서는 오버로딩이 있는데, 같은 함수를 여러 개 만들어야 하는 문제가 있다.
//코틀린에서는 디폴트 파라미터라는 게 있다. => 하나의 함수로 만들 수 있다.
//기본값을 3, true 로 넣어줄 수 있다.
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

//같은 타입의 여러 파라미터 받기(가변인자)
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}