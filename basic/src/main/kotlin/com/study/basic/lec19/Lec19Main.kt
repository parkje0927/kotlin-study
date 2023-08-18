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

    //TakeIf 와 TakeUnless
}

typealias FruitFilter = (FruitV2) -> Boolean

fun filterFruits(fruits: List<FruitV2>, filter: FruitFilter) {

}

data class Person(
    val name: String,
    val age: Int
)