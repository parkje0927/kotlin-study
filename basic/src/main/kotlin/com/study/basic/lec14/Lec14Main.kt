package com.study.basic.lec14

fun main() {
    val personDto1 = PersonDto("test1", 20)
    val personDto2 = PersonDto("test2", 200)
    println(personDto1 == personDto2)

    handleCountry(Country.KOREA)

    handleCar(ACar())
}

fun handleCar(car: HyundaiCar) {
    when (car) {
        is ACar -> TODO()
        is BCar -> TODO()
        is CCar -> TODO()
    }
}

fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}

data class PersonDto(
    val name: String,
    val age: Int
)

enum class Country(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("AMERICA")
}

sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class ACar : HyundaiCar("A", 1_000L)
class BCar : HyundaiCar("B", 2_000L)
class CCar : HyundaiCar("C", 3_000L)

/**
 * Data Class
 * - Dto 클래스
 * -> 자동으로 equals, hashCode, toString 메소드를 만들어준다.
 * -> 사실상 builder, equals, hashCode, toString 다 있는 것
 * => 자바에서는 비슷하게 record 클래스 도입
 *
 * Enum Class
 * - 추가적인 클래스를 상속받을 수 없다.
 * - 인터페이스는 구현할 수 있으며, 각 코드가 싱글톤이다.
 * - when 은 Enum Class 혹은 Sealed Class 와 함께 사용할 경우, 더욱더 진가를 발휘한다.
 * -> enum 클래스 타입에 따라 로직 처리를 한다고 치면, if 문 길어질 수 있다. 그리고 else 로직 처리가 애매하다.
 * -> 코틀린에서는 when 을 통해 좀 더 분명한 처리 가능하고, 컴파일러가 country 의 모든 타입을 알고 있어서
 * 다른 타입에 대한 로직(else)를 작성하지 않아도 된다.
 *
 * Sealed Class
 * - 상속이 가능하도록 추상클래스를 만들려고 하는데 외부에서는 이 클래스를 상속받지 않았으면 한다.
 * -> 하위 클래스를 봉인하자
 * - 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다. 즉 런타임때 클래스 타입이 추가될 수 없다.
 * - 하위 클래스는 같은 패키지에 있어야 한다.
 * - Enum 과 다른 점
 *  - 클래스를 상속받을 수 있다.
 *  - 하위 클래스는 멀티 인스턴스가 가능하다.
 * -> 추상화가 필요한 Entity or Dto 에 sealed class 를 활용한다.
 * & jdk 17 에도 Sealed Class 가 추가되었다.
 *
 * Sealed Interface
 */