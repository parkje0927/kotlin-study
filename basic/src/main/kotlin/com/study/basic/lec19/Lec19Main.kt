package com.study.basic.lec19

import com.study.basic.lec18.FruitV2
import com.study.basic.lec14.handleCar as handleCarA

fun main() {
    //Type Alias, as import
    /**
     * Type Alias : 긴 이름의 클래스 혹은 함수 타입이 있을 때 축약하거나 더 좋은 이름을 쓰고 싶다.
     *
     * 다른 패키지의 같은 이름 함수를 동시에 가져오고 싶다면 -> as import
     * => 어떤 클래스나 함수를 임포트할 때 이름을 바꾸는 기능
     */
//    handleCarA(null)

    //구조분해와 componentN 함수
    val person = Person("name", 100)

    val (name, age) = person
//    val name = person.component1()
//    val age = person.component2()

    println("이름 : ${name}, 나이 : ${age}")

    //Jump 와 Label
    /**
     * return : 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환된다.
     * break : 가장 가까운 루프가 제거된다.
     * continue : 가장 가까운 루프를 다음 step 으로 보낸다.
     *
     */
    val numbers = listOf(1, 2, 3)
    numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }
    //forEach 에서는 break, continue 를 사용할 수 없다.
    //그런데 꼭 쓰고 싶다면,

    //break
    run {
        numbers.forEach { number ->
            if (number == 2) {
                return@run
            }
        }
    }

    //하지만 break, continue 를 사용하고 싶다면 for 문 사용을 추천!!

    //아래 라벨을 사요한 jump 는 사용하지 않는 것을 추천!!
    /**
     * @run, @forEach 등과 같이,
     * 특정 expression 에 라벨이름@ 을 붙여 하나의 라벨로 간주하고
     * break, continue, return 등을 사용하는 기능
     */
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                //이 경우 가장 밖에 있는 for 문, 즉 loop@가 있는 반복문을 멈춘다.
                //라벨명은 아무거나 해도 된다.
                break@loop
            }
            print("$i $j")
        }
    }

    //TakeIf 와 TakeUnless
    /**
     * takeIf : 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null 이 반환된다.
     * takeUnless : 주어진 조건을 만족하지 않으면 그 값이, 그렇지 않으면 null 이 반환된다.
     */
    fun getNumberOrNullV2(): Int? {
        var number = 3
        return number.takeIf { it > 0 }
    }
}

typealias FruitFilter = (FruitV2) -> Boolean

fun filterFruits(fruits: List<FruitV2>, filter: FruitFilter) {

}

//data class Person(
//    val name: String,
//    val age: Int
//)

//data 클래스가 아니지만 직접 componentN 함수를 만들어줄 수 있다.
class Person(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}