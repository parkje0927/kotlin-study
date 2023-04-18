package com.study.basic.lec09

class PersonV3(
    name: String = "park",
    var age: Int = 1
) {
    //setter
    //여기서도 무한루프 발생을 방지하기 위해 field 를 사용한다.
    //하지만 setter 는 지양하기 때문에 update 함수 같은 것을 만들어서 사용하는 것을 추천한다.
    var name = name
        set(value) {
            field = value.uppercase()
        }
}