package com.study.basic.lec01

import com.study.basic.domain.KotlinPerson

fun main() {

    /**
     * 변수 선언 키워드 - var, val 차이점
     * Java
     * - long : 가변
     * - final long : 불변
     */
    var number1: Long = 10L; //가변 -> 재할당 가능
    val number2 = 10L; //불변 -> 재할당 불가능 but 컬렉션일 경우 값을 추가하는 것은 가능하다.
    var number3: Int
//    println(number3) -> 값이 없어서 에러 발생한다.

    /**
     * 모든 변수는 우선 val 로 만들고 꼭 필요한 경우 var 로 변경한다.
     */

    /**
     * Java
     * long : primitive type
     * Long : reference type => 연산을 할 때는 사용하지 마라 불필요한 언박싱 생기기 때문임.
     *
     * Kotlin
     * 숫자, 문자, 불리언과 같은 몇몇 타입은 내부적으로 특별한 표현을 갖는다.
     * 이 타입들은 실행시에 Primitive Value 로 표현되지만, 코드에서는 평범한 클래스처럼 보인다.
     * -> 연산을 하게 되면 내부적으로는 알아서 primitive type 으로 바꿔서 실행을 해준다.
     * 즉 프로그래머가 boxing/unboxing 을 고려하지 않아도 되도록 kotlin 이 알아서 처리해준다.
     */

    /**
     * nullable 변수
     * reference type 은 null 이 들어갈 수 있다는 의미인데,
     * kotlin 은 기본적으로 null 이 들어가지 못하도록 설계가 되어 있다.
     * 따라서 타입 뒤에 `?` 를 붙여줘야 한다.
     */
    var number4: Long = 10L
//    var number5 = 1_1000L
//    number5 = null //기본적으로 null 이 들어가지 못하도록 설계가 되어있다.
    var number5: Long? = 1_000L
    number5 = null

    /**
     * 객체 선언
     * Java => Person person = new Person("abc");
     * Kotlin => new 를 쓰지 않음.
     */
    var person = KotlinPerson("abc", 100)

}