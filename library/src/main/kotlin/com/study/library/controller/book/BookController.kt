package com.study.library.controller.book

import com.study.library.dto.book.request.BookLoanRequest
import com.study.library.dto.book.request.BookRequest
import com.study.library.dto.book.request.BookReturnRequest
import com.study.library.service.book.BookService
import org.springframework.web.bind.annotation.*

@RestController
class BookController(
    private val bookService: BookService
) {

    @PostMapping("/book")
    fun saveBook(@RequestBody bookRequest: BookRequest) {
        bookService.saveBook(bookRequest)
    }

    @PostMapping("/book/loan")
    fun loanBook(@RequestBody bookLoanRequest: BookLoanRequest) {
        bookService.loanBook(bookLoanRequest)
    }

    @PutMapping("/book/return")
    fun returnBook(@RequestBody bookReturnRequest: BookReturnRequest) {
        bookService.returnBook(bookReturnRequest)
    }

}