package com.study.library.domain.book

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Book(
    //getter 는 프로퍼티에 생기므로 따로 생성 불필요

    //바뀌지 않음, null 허용 X
    val name: String,

    //바뀌지 않음, null 허용, 초기값 null, 디폴트 파라미터는 가장 아래에 두는 게 관례
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없습니다.")
        }
    }
}

/**
 * 1. backing property 사용하기
 *
 * ```
 * class User(
 *  private var _name: String
 * ) {
 *  val name: String
 *      get() = this._name
 * }
 * ```
 *
 * 2. custom setter 이용하기
 * class User(
 *  name: String
 * ) {
 *  var name = name
 *      private set
 *
 * -> 두 방법 모두 복잡하다.
 */