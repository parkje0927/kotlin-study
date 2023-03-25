package com.study.basic.lec02

import com.study.basic.domain.JavaPerson

fun main() {

    /**
     * null 체크
     * - kotlin 에서는 null 이 가능한 타입을 완전히 다르게 취급한다.
     * - 한 번 null 검사를 하면 non-null 임을 컴파일러가 알 수 있다.(해당 변수는 초록색으로 배경색이 들어간다.)
     * - null 이 가능한 타입만을 위한 기능은 없나?
     * ->
     */

    //1. safe call => ?.
    val str: String? = "ABC"
//    println(str.length) -> null 가능성이 있어서 불가능
    println(str?.length) //null 이면 null 출력하고, 아니면 이 함수 실행

    //2. Elvis 연산자 => ?:
    val str2: String? = null
    println(str2?.length ?: 0)

    //3. null 아님 단언 => !!
    //nullable type 이지만, 아무리 생각해도 null 이 될 수 없는 경우
    //절대 null 이 아니야!! 라고 말하는 것
    println(startsWithA4("ABC"))
//    println(startsWithA4(null)) //런타임에서 NPE 발생한다.

    //4. 플랫폼 타입
    //코틀린이 null 관련 정보를 알 수 없을 시 Runtime Exception 이 발생할 수 있다.
    //즉, 코틀린 코드에서 자바 코드(Person 객체) 가져다 쓸 때, Nullable 이나 NotNull 어노테이션이 아예 없으면 Runtime Exception 이 발생한다.
    //혹은 Nullable 인데 아래와 같이 str 에 대해 safe call 을 하지 않을 경우 오류가 발생한다.
    //따라서 어노테이션을 잘 붙여주고, 이를 safe call 실행해주면 좋다.
    //-> Java 코드를 읽으며 null 가능성을 확인하거나 Kotlin 으로 wrapping 해서 자바 코드 가져오는 것을 최소화하자
    val person = JavaPerson(null)
    startsWithA(person.name)
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}

fun startsWithA1(str: String?): Boolean {
//    if (str == null) {
//        throw IllegalArgumentException("null 이 있습니다.")
//    }
//    return str.startsWith("A")

    return str?.startsWith("A") ?: throw IllegalArgumentException("null 이 있습니다.")
}

fun startsWithA2(str: String?): Boolean? {
//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")

    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
//    return str.startsWith("A") -> null 가능성이 있어서 오류

//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")

    return str?.startsWith("A") ?: false
}

fun startsWithA4(str: String?): Boolean {
    return str!!.startsWith("A")
}