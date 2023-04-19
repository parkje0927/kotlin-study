package com.study.basic.lec10

class Cat(
    species: String
) : Animal(species, 4) {
    //extends 를 사용하지 않고 : 을 사용하고, 한 칸 띄어서 쓴다.
    override fun move() {
        println("고양이가 걸어가")
    }
}