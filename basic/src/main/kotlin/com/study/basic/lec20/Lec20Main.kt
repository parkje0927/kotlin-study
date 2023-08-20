package com.study.basic.lec20

fun main() {
    /**
     * scope function
     * 무엇인지?
     * - 일시적인 영역을 형성하는 함수
     * - 람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나,
     * method 체이닝 에 활용하는 함수를 scope function 이라고 한다.
     *
     * 분류 (외우지 말기!!)
     * - let : 확장함수, 람다를 받아 람다 결과를 반환한다. 람다 안에서 it 사용
     * - run : 확장함수, 람달의 결과를 반환, 람다 안에서 this 사용
     * - also : 확장함수, 객체 그 자체 반환, 람다 안에서 it 사용
     * - apply : 확장함수, 객체 그 자체 반환, 람다 안에서 this 사용
     * - with : 확장함수 X, this 를 사용해 접근하고, this 는 생략 가능하다.
     *
     * this : 생략이 가능한 대신 다른 이름을 붙일 수 없다.
     * it : 생략은 불가능하고 다른 이름 붙일 수 있다.
     *
     * 언제 사용
     * - let
     *  - 하나 이상의 함수를 call chain 결과로 호출할 때
     *  - non-null 값에 대해서만 code block 을 실행시킬 때
     *  - 일회성으로 제한된 영역에 지역 변수를 만들 때
     * - run
     *  - 객체 초기화와 반환값의 계산을 동시에 해야할 때
     * - apply
     *  - 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때
     * - also
     *  - 객체를 수정하는 로직이 call chain 중간에 필요할 때
     *
     * 가독성
     * - 아래 1, 2번 코드에서 뭐가 더 좋을지? 가독성면에서는 1번이 더 좋은 것 같다.
     * - 적절하게 사용하면 유용하게 활요할 수 있다.
     */
}

data class Person(
    val name: String,
    val age: Int
) {
    fun isAdult(): Boolean {
        return age >= 19
    }
}

fun printPerson(person: Person?) {
    person?.let {
        print(it.name)
        print(it.age)
    }
}

fun printPersonV2(person: Person) {
    val value1 = person.let {
        it.age
    }

    val value2 = person.run {
        this.age
    }

    //value3 => Person 이다.
    val value3 = person.also {
        it.age
    }

    //value4 => Person 이다.
    val value4 = person.apply {
        this.age
    }
}

fun printPersonV3(person: Person) {
    //1번 코드
    if (person != null && person.isAdult()) {
        //view.showPerson(person)
    } else {
        //view.showError()
    }

    //2번 코드
//    person?.takeIf { it.isAdult() }
//        ?.let(view::showPerson)
//        ?: view.showError()
}


