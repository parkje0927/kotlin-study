package com.study.basic.lec03

import com.study.basic.domain.PersonKotlin

fun main() {

    /**
     * 코틀린에서 Type 을 다루는 방법
     * 1. 기본 타입
     * 2. 타입 캐스팅
     * 3. kotlin 의 3가지 특이한 타입
     * 4. String Interpolation, String indexing
     */

    //1. 기본 타입
    //선언된 기본값을 보고 타입을 추론한다.
    //java 에서는 더 큰 타입으로 암시적으로 변경이 되었지만,
    //kotlin 에서는 기본 타입간의 변환은 명시적으로 이루어져야 한다.
    val number1 = 4
//    val number2: Long = number1 -> 오류
    val number2: Long = number1.toLong()

    //nullable 은 적절한 처리가 필요하다.
    val number3: Int? = 3
    val number4: Long = number3?.toLong() ?: 0

    //3. kotlin 의 3가지 특이한 타입
    /**
     * Any
     * - java 의 Object 역할(모든 객체의 최상위 타입
     * - 모든 Primitive Type 의 최상의 타입도 Any 이다.
     * - Any 자체로는 null 을 포함할 수 없어 null 을 포함하고 싶다면, Any? 로 표현
     * - Any 에 equals, hashcode, toString 존재
     */

    /**
     * Unit
     * - java 의 void 와 동일한 역할
     * - void 와 다르게 Unit 은 그 자체로 타입 인자로 사용가능하다.
     * - 함수형 프로그래밍에서 Unit 은 단 하나의 인스턴스만 갖는 타입을 의미
     * 즉, 코틀린의 Unit 은 실제 존재하는 타입이라는 것을 표현
     */

    /**
     * Nothing
     * - 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
     * - 무조건 예외를 반환하는 함수 / 무한 루프 함수 등
     */

    //4. String Interpolation, String indexing
    val person = PersonKotlin("test", 100)
    val log = "이름 : ${person.name} 나이 : ${person.age}"
    println(log)

    val name = "test"
    val str = """
        ABC
        DEF
        $name
    """.trimIndent()
    println(str)

    val str2 = "ABCDE"
    val ch = str2[2]
    println(ch)
}

//2. 타입 캐스팅
fun printAgeIfPerson(obj: Any) {
    if (obj is PersonKotlin) {
//        val person = obj as PersonKotlin //java 의 (Person) obj 와 같은 의미이다. 이는 val person = obj 라고 써도 무방하다.
        println(obj.age)
    } else if (obj !is PersonKotlin) {

    }
}

fun printAgeIfPerson2(obj: Any?) {
    val person = obj as? PersonKotlin
    println(person?.age)
}

/**
 * value is Type
 * value as Type
 * value as? Type
 */


