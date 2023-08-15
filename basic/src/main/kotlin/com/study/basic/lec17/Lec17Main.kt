package com.study.basic.lec17

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("사과", 1700),
        Fruit("바나나", 3500),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[1])

    val isApple3: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "바나나" }

    filterFruits(fruits, isApple2)
    filterFruits(fruits) { fruit -> fruit.name == "수박" }
    filterFruits(fruits) { it.name == "수박" }

    //
    var targetFruitName = "바나나"
    targetFruitName = "수박"
    filterFruits(fruits) { it.name == targetFruitName }
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    val result = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            result.add(fruit)
        }
    }
    return result
}


class Fruit(
    var name: String,
    var prive: Int
)

/**
 * 자바에서는 함수는 2급 시민이다. 변수에 할당되거나 파라미터로 전달할 수 없다.
 * 코틀린에서는 함수가 1급 시민이다.그 자체로 값이 될 수 있다. 변수에 할당 될 수도 있고 파라미터로 넘길 수 있다.
 *
 * 자바에서는 람다를 쓸 때, final 인 변수만 사용가능하다.
 * 코틀린은 그렇지 않다. 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있다.
 * 이렇게 해야만 람다를 진정한 일급 시민으로 간주할 수 있다. 이 데이터 구조를 Closure 라고 부른다.
 * Closure 를 사용하여 non-final 변수도 람다에서 사용할 수 있다.
 * 
 * - use
 */