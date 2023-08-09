package com.study.toy.service

import com.study.toy.dto.request.BoardSaveRequest
import com.study.toy.repository.BoardJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private val boardJpaRepository: BoardJpaRepository
) {

    @Transactional
    fun saveBoard(boardSaveRequest: BoardSaveRequest) {
        val board = boardSaveRequest.toEntity()
        boardJpaRepository.save(board)
    }
}