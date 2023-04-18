package com.study.basic.lec09

class PersonV2(
    name: String = "park",
    var age: Int = 1
) {
    //왜 field 를 사용할까?
    //name.uppercase() 를 하면, name 은 name 에 대한 getter 를 호출하니까 다시 get 을 부른다!!
    //무한루프 발생! -> 무한루프를 막기 위한 예약어, 자기 자신을 가리킨다. field 라고 하면 name 을 가리키는 것이다.
    //이를 backing field 라고 부른다.
    val name = name
        get() = field.uppercase()
    //<- 이렇게 사용하는 것보다 아래 방법을 추천

    fun getUppercaseName(): String {
        return this.name.uppercase()
    }

    val uppercaseName: String
        get() = this.name.uppercase()

    init {

    }
}