package com.study.library.domain.user

import com.study.library.domain.book.Book
import com.study.library.domain.user.loanhistory.UserLoanHistory
import jakarta.persistence.*

/**
 * entity 클래스에는 data class 를 피하는 것이 좋다.
 * 이유는, equals, hashCode, toString 모두 JPA Entity 와 어울리지 않기 때문이다.
 *
 * entity 가 생성되는 로직을 찾고 싶다면 constructor 지시어를 명시적으로 작성하고 추적하자!
 */
@Entity
class User(

    var name: String,

    val age: Int?,

    /**
     * 여기 생성자 안에 프로퍼티를 다 넣는 것이 아니라
     * 아래 {} body 안에 넣을 수도 있다.
     *
     * -> 모든 프로퍼티를 생성자에 넣거나
     * or 생성자 혹은 클래스 body 안에 구분해서 넣을 때 명확한 기준이 있으면 된다.
     */

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories: MutableList<UserLoanHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없습니다.")
        }
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun loanBook(book: Book) {
        this.userLoanHistories.add(UserLoanHistory(this, book.name, false))
    }

    fun returnBook(bookName: String) {
        //true 인 첫번째 값
        this.userLoanHistories.first { history -> history.bookName == bookName }.doReturn()
    }
}