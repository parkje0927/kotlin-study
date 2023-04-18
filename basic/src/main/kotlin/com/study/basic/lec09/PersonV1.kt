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

    val person2 = Person("jung")

    val person3 = Person()
//    초기화 블록
//    부생성자1
//    부생성자2
}

//class Person(
//    val name: String,
//    var age: Int
//)

//생성자 검증 로직 추가
class Person(
    //기본 생성자
    val name: String,
    var age: Int
) {
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age} 일 수 없습니다.")
        }
        println("초기화 블록")
    }

    //두번째 생성자, 부생성자
    constructor(name: String) : this(name, 1) {
        println("부생성자1")
    }

    //두번째 생성자를 부르고 -> 두번째 생성자는 다시 첫번째 생성자를 부른다.
    constructor() : this("홍길동") {
        println("부생성자2")
    }

    fun isAdult(): Boolean {
        return this.age >= 20
    }

    //custom getter
    val isAdult: Boolean
        get() = this.age >= 20

    val isAdult2: Boolean
        get() {
            return this.age >= 20
        }
}

//부생성자보다는 default parameter 를 권장한다.
//부생성자보다 정적 팩토리 메소드를 추천한다.