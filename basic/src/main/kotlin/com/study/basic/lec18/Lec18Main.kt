package com.study.basic.lec18

fun main() {
    //필터와 맵
    val fruits = listOf(
        FruitV2(1, "사과", 1000),
        FruitV2(2, "사과", 1200),
        FruitV2(3, "사과", 1500),
        FruitV2(4, "사과", 1700),
        FruitV2(5, "바나나", 3500),
        FruitV2(6, "바나나", 2500),
        FruitV2(7, "수박", 10000)
    )

    fruits.filter { fruit -> fruit.name == "사과" }.map { fruit -> fruit.price }
    fruits.filter { fruit -> fruit.name == "바나나" }
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.price
        }
//    fruits.filter { fruit -> fruit.name == "사과" }.mapNotNull { fruit -> fruit.name() }

    /**
     * filter
     * filterIndexed
     * map
     * mapIndexed
     * mapNotNull
     */

    fruits.any { fruit -> fruit.price >= 10_000 }

    fruits.count()
    fruits.sortedBy { fruit -> fruit.price } //오름차순
    fruits.sortedByDescending { fruit -> fruit.price } //내림차순
    fruits.distinctBy { fruit -> fruit.name }.map { fruit -> fruit.name }

    fruits.first() //첫번째값을 가져온다(무조건 null 이 아니어야 함)
    fruits.firstOrNull() //첫번째값 또는 null 을 가져온다.

    //과일 이름 -> List<과일>
    val map: Map<String, List<FruitV2>> = fruits.groupBy { fruit -> fruit.name }

    //id -> 과일
    fruits.associateBy { fruit -> fruit.id }

    //name -> price Map
    fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.price })

    fruits.groupBy { fruit -> fruit.name }.filter { (key, value) -> key == "사과" }
}

private fun filterFruits(
    fruits: List<FruitV2>, filter: (FruitV2) -> Boolean
): List<FruitV2> {
    return fruits.filter(filter)
}

class FruitV2(
    var id: Int,
    var name: String,
    var price: Int
)