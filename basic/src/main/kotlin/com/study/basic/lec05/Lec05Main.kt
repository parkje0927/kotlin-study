package com.study.basic.lec05

fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

/**
 * Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다. => java 의 if ~ else
 * Expression : 하나의 값으로 도출되는 문장 => kotlin 의 if ~ else
 * Expression 이 Statement 에 포함된다.
 */

fun getPassOrFail(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun rangeCheck1(score: Int) {
    if (score !in 0..100) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

fun rangeCheck2(score: Int) {
    if (score in 0..100) {
        println("okay")
    }
}

fun getGradeWithSwitch1(score: Int): String {
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "0"
    }
}

fun getGradeWithSwitch2(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "0"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when(obj) {
        is String -> true
        else -> false
    }
}

fun judgeNumber1(number: Int) {
    when(number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("-1, 0, 1 이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0 입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}