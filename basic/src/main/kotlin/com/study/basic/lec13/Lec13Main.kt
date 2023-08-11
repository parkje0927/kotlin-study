package com.study.basic.lec13

fun main() {

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    //권장되는 클래스 안의 클래스 => 그냥 클래스 만들듯이 만들면 된다.
    class LivingRoom(
        private val area: Double
    )
    
    //권장되지 않는 클래스 안의 클래스 => 기본적으로 바깥 클래스 참조하지 않는다. 굳이 바깥 클래스를 참조하고 싶다면 inner 키워드를 추가한다.
//    inner class LivingRoom(
//        private val area: Double
//    ) {
//        val address: String
//            get() = this@House.address
//    }
}

/**
 * static 을 사용하는 중첩 클래스
 * -> 권장되지 않는 클래스 안의 클래스
 *
 * static 을 사용하지 않는 중첩 클래스
 * - inner class 내부 클래스
 * -> Java 의 경우, 내부 클래스가 외부 클래스를 참조함으로써 몇 가지 문제점이 있다.
 * -> 클래스 안에 클래스를 만들 때는 static 클래스를 만들어라
 * -> 권장되는 클래스 안의 클래스
 */