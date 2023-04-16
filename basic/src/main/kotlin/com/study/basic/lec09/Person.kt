package com.study.basic.lec09

//class Person constructor(name: String, age: Int) { -> constructor 생략
//class Person(name: String, age: Int) {
//
//    /**
//     * 프로퍼티 = 필드 + getter + setter
//     * 코틀린에서는 필드만 만들면 getter, setter 를 자동적으로 만들어준다.
//     */
//    val name = name
//    var age = age
//}

fun main() {
    val person = Person("park", 20)

    // . 프로퍼티로 getter, setter 를 사용한다. 자바로 만들어진 클래스 객체를 생성해도 . 프로퍼티를 사용할 수 있다.
    println(person.age)
    println(person.name)

    person.age = 10
    println(person.age)
}

class Person(
    val name: String,
    var age: Int
)