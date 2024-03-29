package com.study.library.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

//fun main() {
//    val calculatorTest = CalculatorTest()
//    calculatorTest.addTest()
//    calculatorTest.minusTest()
//    calculatorTest.multiplyTest()
//    calculatorTest.divideTest()
//}

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
     *
     * - 단언문
     * assertThat().extracting().containsExactlyAnyOrder => 순서 중요 X
     * assertThat().extracting().containsExactly => 순서 중요 O
     */

    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAll() {
            println("모든 test 시작 전")
        }

        @JvmStatic
        @AfterAll
        fun afterAll() {
            println("모든 test 종료 후")
        }
    }

    @Test
    fun addTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.add(3)

        //then
        //i)
//        val expectedCalculator = Calculator(8)
//        if (calculator != expectedCalculator) {
//            throw IllegalStateException()
//        }
        //ii)
//        if (calculator.number != 8) {
//            throw IllegalStateException()
//        }

        assertThat(calculator.number).isEqualTo(8)
    }

    @Test
    fun minusTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.minus(3)

        //then
        assertThat(calculator.number).isEqualTo(2)
    }

    @Test
    fun multiplyTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.multiply(3)

        //then
        assertThat(calculator.number).isEqualTo(15)
    }

    @Test
    fun divideTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.divide(2)

        //then
        assertThat(calculator.number).isEqualTo(2)
    }

    @Test
    fun divideWithZeroTest() {
        //given
        val calculator = Calculator(5)

        //when
//        try {
//            calculator.divide(0)
//        } catch (e: IllegalArgumentException) {
//            if (e.message != "0으로 나눌 수 없습니다.") {
//                throw IllegalStateException("예외 메세지가 다릅니다.")
//            }
//            //success
//            return
//        } catch (e: Exception) {
//            //fail
//            throw IllegalStateException()
//        }
        //then
//        throw IllegalStateException("기대하는 예외가 발생하지 않았다.")

        assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }.apply {
            assertThat(message).isEqualTo("0으로 나눌 수 없습니다.")
        }

    }
}