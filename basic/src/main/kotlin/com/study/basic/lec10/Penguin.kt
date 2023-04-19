package com.study.basic.lec10

class Penguin(
    species: String
) : Animal(species, 2), Swim, Fly {

    //인터페이스 구현도 : 을 사용한다.
    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다.")
    }

    //프로퍼티 오버라이드시 open 을 붙여줘야한다. -> Animal 에 open legCount
    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swim>.act()
        super<Fly>.act()
    }

    override val swimAbility: Int
        get() = 3
}