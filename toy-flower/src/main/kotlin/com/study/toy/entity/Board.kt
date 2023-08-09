package com.study.toy.entity

import jakarta.persistence.*

@Table(name = "board")
@Entity
data class Board(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "email")
    var email: String,

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String
) : BaseTimeEntity() {

    fun toEntity(): Board {
        return Board(email = email, title = title, content = content)
    }
}