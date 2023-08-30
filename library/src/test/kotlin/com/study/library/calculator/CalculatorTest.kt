package com.study.library.calculator

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
}

class CalculatorTest {

    /**
     * i) Calculator 클래스를 data class 로 만들거나,
     * ii) 변수인 number 를 public 으로 만들어서(private 삭제) calculator.number != 8 로 검증해도 된다.
     * iii) 변수인 number 를 private 으로 두고, private var _number: Int
     * -> getter 만 public 으로 한 뒤
     * -> calculator.number != 8 로 검증
     *
     * but, setter 사용하지 않도록 하되, 코드 간결성 유지하기
     * => 2번
     */
    fun addTest() {
        val calculator = Calculator(5)
        calculator.add(3)

        val expectedCalculator = Calculator(8)
//        if (calculator != expectedCalculator) {
//            throw IllegalStateException()
//        }
        if (calculator.number != 8) {
            throw IllegalStateException()
        }
    }
}