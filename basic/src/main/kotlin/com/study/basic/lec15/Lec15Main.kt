package com.study.basic.lec15

fun main() {
    //배열
    val array = arrayOf(100, 200)

    for (i in array.indices) {
        println("$i ${array[i]}")
    }
    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }

    array.plus(300)

    //List
    val numbers = listOf(100, 200) //불변 리스트
    val emptyList = emptyList<Int>()
    val emptyList2 = printNumbers(emptyList) //타입 추론이 가능하면 <> 를 생략 가능

    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {
        println("$idx $value")
    }

    //가변 리스트(기본 구현체 : LinkedList)
    val mutableList = mutableListOf(100, 200)

    //집합
    val numbers2 = setOf(100, 200)

    //가변 집합(기본 구현체 : LinkedHashSet)
    val mutableSet = mutableSetOf(100, 200)

    //Map
    val mutableMap = mutableMapOf<Int, String>() //타입을 추론할 수 없어 타입을 지정해주었다.
    mutableMap.put(1, "test1")
    mutableMap[2] = "test2"

    mapOf(3 to "test3", 4 to "test4")

    for (key in mutableMap.keys) {
        println(key)
        println(mutableMap[key])
    }

    for ((key, value) in mutableMap.entries) {
        println("$key $value")
    }

}

private fun printNumbers(numbers: List<Int>) {

}

/**
 * 배열
 * - 배열은 잘 사용하지 않는다.(배열보다 리스트 사용 추천)
 *
 * Collection
 * - 컬렉션을 만들어줄 때 불변인지, 가변인지를 설정해야 한다.
 * - Iterable 이 가장 위에 있고, 그 아래 List, Set, Map 이 있고, 그 아래에 MutableList, MutableSet, MutableMap 이 있다.
 *                    Iterable
 * List                 Set             Map
 * MutableList      MutableSet      MutableMap
 *
 * - 가변(Mutable) 컬렉션 : 컬렉션에 element 를 추가, 삭제할 수 있다.
 * - 불변 컬렉션 : 컬렉션에 element 를 추가, 삭제할 수 없다.
 * -> Collection 을 만들자마다 Collections.unmodifiableList() 등을 분여준 게 불변이다!
 *
 * - 불변 컬렉션이라 하더라도 Reference Type 인 Element 의 필드는 바꿀 수 있다.
 * - 우선 불변 리스트로 만들고 -> 꼭 필요한 경우 가변 리스트로 바꾸자!
 *
 * 컬렉션의 null 가능성
 * - List<Int?> : 리스트에 null 이 들어갈 수 있지만, 리스트는 절대 null 이 아님.
 * - List<Int>? : 리스트에는 null 이 들어갈 수 없지만, 리스트는 null 일 수 있음.
 * - List<Int?>? : 리스트에 null 이 들어갈 수도 있고, 리스트도 null 일 수 있음.
 *
 * 자바는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않는다. 만약 자바에 의해 element 가 추가되면 코틀린에서 문제가 생긴다.
 * 또한 자바는 nullable 타입과 non-nullable 타입을 구분하지 않는다.
 * 그래서 코틀린쪽에서는 자바에서 호출되면 컬렉션 내용이 변할 수 있음을 감안해야 하고,
 * 코틀린 쪽에서 Collections.unmodifiableXXX() 를 활용하면 변경 자체를 막을 수 있다.
 * 
 */
