package com.study.basic.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {

    /**
     * try catch finally
     *
     * Checked Exception, Unchecked Exception
     * - kotlin 에서는 checked exception 과 unchecked exception 을 구분하지 않는다.
     * - 모두 unchecked exception 이다.
     *
     * try with resources
     */

    readFile()
}

//try catch finally
fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str} 은 숫자가 아닙니다.")
    }
}

fun parseIntOrThrow2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

//Checked Exception, Unchecked Exception
fun readFile() {
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

//try with resources => kotlin 에는 없다.
fun readFileWithResources(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}