package com.study.basic.lec11

fun main() {

    /**
     * 접근제어자
     *
     * public => 기본 접근 제어자
     * protected : **선언된 클래스** 또는 하위 클래스에서만 접근 가능
     * internal : **같은 모듈**에서만 접근 가능
     * private : 선언된 클래스내에서만 접근 가능
     *
     * 생성자는 접근제어자를 붙이려면 constructor 를 써줘야한다.
     * 자바에서는 코틀린 모듈의 internal 코드를 가져올 수 있다.
     * 프로퍼티의 custom setter 에 접근 지시어를 붙일 수 있다.
     */
}

class Cat protected constructor(

)