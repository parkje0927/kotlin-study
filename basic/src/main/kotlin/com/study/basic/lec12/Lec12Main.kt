package com.study.basic.lec12

fun main() {
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)

    moveSomething(object : Movable {
        override fun move() {
            println("move")
        }

        override fun fly() {
            println("fly")
        }
    })
}

class Person private constructor(
    var name: String,
    var age: Int,
) {

    // static 대신 companion object 사용한다.
    companion object Factory : Log {
        //val => 런타임 시에 변수가 할당
        //const => 컴파일 시에 변수가 할당, 진짜 상수에 붙이기 위한 용도, 기본 타입과 String 에만 붙일 수 있다.
        private const val MIN_AGE = 1
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("Person 클래스의 동행 객체 Factory 이다.")
        }
    }

}

/**
 * static : 클래스가 인스턴스화 될 때 새로운 값이 복제되는 게 아니라 정적으로 인스턴스끼리의 값을 공유
 * companion object : 클래스와 동행하는 유일한 오브젝트
 * - 동반객체도 하나의 객체로 간주된다.
 * - 때문에 이름을 붙일 수도 있고, interface 를 구현할 수도 있다.
 * - 최상단 파일을 활용하는 것을 추천
 * Factory 라는 이름이 없다면 이 companion object 를 활용할 때, Person.Companion.newBaby("ABC") 이라고 쓴다.
 * 아니면, newBaby 함수 위에 @JvmStatic 붙여주면 바로 활용할 수 있다.(Person.newBaby("ABC"))
 * 혹은, Factory 처럼 이름이 있다면, Person.Factory.newBaby("ABC") 이렇게 사용할 수 있다
 */

/**
 * 싱글톤
 * - object 활용
 */
object Singleton {
    var a: Int = 0
}

/**
 * 익명 클래스
 * - 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
 */
private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}