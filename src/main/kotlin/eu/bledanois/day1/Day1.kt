package eu.bledanois.day1

import java.io.File

fun part1(file: File): Int {
    var sum = 0
    file.readLines().forEach {
        val digits = mutableListOf<String>()

        for (char in it) {
            if (char.isDigit()) {
                digits.add(char.toString())
            }
        }

        sum += (digits.first() + digits.last()).toInt()
    }

    return sum
}

fun part2(file: File): Int {

    var sum = 0

    val words = mapOf(
        "one" to '1',
        "two" to '2',
        "three" to '3',
        "four" to '4',
        "five" to '5',
        "six" to '6',
        "seven" to '7',
        "eight" to '8',
        "nine" to '9'
    )

    file.readLines().forEach {
        var i = 0
        val digits = mutableListOf<String>()

        while (i < it.length) {
            if (it[i].isDigit())
                digits.add(it[i].toString())
            else {
                for (number in words) {
                    if ((i + number.key.length) <= it.length) {
                        val str = it.substring(i, i + number.key.length)
                        if (str == number.key) {
                            digits.add(number.value.toString())
                            break
                        }
                    }
                }
            }
            i++
        }
        sum += (digits.first() + digits.last()).toInt()

    }

    return sum
}

fun main() {

    val file1 = File("src/main/kotlin/eu/bledanois/day1/input1.txt")
    val file2 = File("src/main/kotlin/eu/bledanois/day1/input2.txt")

    println(part1(file1))
    println(part2(file2))

}