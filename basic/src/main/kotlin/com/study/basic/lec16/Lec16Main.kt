package com.study.basic.lec16

fun main() {
    val str = "ABCD"
    println(str.lastChar())

    3.add(4)
    3 add2 4
}

//확장함수를 만든다고 가정, 가장 마지막 문자를 가져오는 함수
fun String.lastChar(): Char {
    return this[this.length - 1]
}

//확장함수
fun Int.add(other: Int): Int {
    return this + other
}

//중위함수
infix fun Int.add2(other: Int): Int {
    return this + other
}

//inline 함수
inline fun Int.add3(other: Int): Int {
    return this + other
}

//지역 함수
fun createPeron(firstName: String, lastName: String): Person {
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            //throw exception
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}

class Person(
    var firstName: String,
    var lastName: String,
    var age: Int
)

/**
 * 확장함수
 * fun 확장하려는 클래스.함수 이름(파라미터): 리턴 타입 { -> 확장하려는 클래스를 '수신 객체 타입'이라고 한다.
 *  //this 를 이용해 실제 클래스 안의 값에 접근 -> this 를 '수신 객체'라고 하고
 * }
 *
 * - 그런데 public 한 확장함수를 통해 수신 객체 클래스의 private 한 것을 가져오면 캡슐화가 깨지는 거 아닌가?
 * - 그래서 확장 함수에서는 private, protected 멤버 변수 못 가져온다.
 *
 * - 확장함수와 멤버함수가 똑같은 시그니처면 -> 멤버함수가 우선적으로 호출된다.
 *
 * - Srt 가 Train 을 상속하고 둘 다 똑같은 확장함수를 가지고 있다고 할 때,
 * 어떤 타입으로 선언하냐에 따라 그 확장함수가 호출된다. -> 현재 타입을 기준으로 호출된다.
 *
 * - 자바에서는 확장함수를 마치 정적메소드를 호출하듯이 호출된다.
 *
 * infix 함수
 *
 * inline 함수
 * - 함수를 파라미ㅓ로 전달할 때 오버헤드를 줄일 수 있다. 콜체인 오버헤드를 줄이기 위해
 * but 성능 측정과 함께 신중하게 사용되어야 한다.
 *
 * 지역 함수
 * - 함수 안에 함수를 선언할 수 있다.
 * - 지금 함수 안에서만 사용하고 싶을 때 사용하는데 depth 도 커지고 그렇게 깔끔하진 않다.
 */