package com.study.toy.repository

import com.study.toy.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardJpaRepository : JpaRepository<Board, Long> {
}