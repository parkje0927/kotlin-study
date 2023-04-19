package com.study.basic.lec10

fun main() {

    /**
     * 1. 추상 클래스
     * 2. 인터페이스
     * 3. 클래스를 상속할 때 주의할 점
     * - 상위 클래스에 constructor 와 Init 블록에서는 final 이 아닌 하위 프로퍼티, 오버라이딩 하고 있는 프로퍼티에 접근하면 안된다.
     * - 상위 클래스를 설계할 때, 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open 을 피해야한다.
     * 4. 상속 관련 지시어 정리
     * - final : override 할 수 없게 한다. default 로 보이지 않게 존재한다.
     * - open : override 를 열어준다.
     * - abstract : 반드시 override 해야 한다.
     * - override : 상위 타입을 오버라이드 하고 있다.
     */
}