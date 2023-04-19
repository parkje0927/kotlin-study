package com.study.basic.lec10

interface Swim {

    //getter 를 구현 받은 클래스에서 구현하는 것을 기대한다.
    //혹은 get() 을 이용해서 디폴트 값을 넣어줄 수 있다.
    //이렇게 backing field 가 없는 프로퍼티를 만들 수 있다.
    val swimAbility: Int
        get() = 3

    fun act() {
        println("어푸 어푸")
    }
}