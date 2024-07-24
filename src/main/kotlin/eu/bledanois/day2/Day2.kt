package eu.bledanois.day2

import java.io.File

const val red = 12
const val green = 13
const val blue = 14


fun part1(file: File): Int {
    var sum = 0
    var count = 1
    var possible = true

    file.readLines().forEach { line ->
        val firstSplit = line.split(":")
        val sets = firstSplit.last()

        val setList = sets.split(";")

        for (set in setList) {
            val balls = set.split(",")

            for (ball in balls) {
                val number = ball.split(" ")[1]
                val color = ball.split(" ").last()

                when(color) {
                    "red" -> if (number.toInt() > red) possible= false
                    "green" -> if (number.toInt() > green) possible= false
                    "blue" -> if (number.toInt() > blue) possible= false
                }

            }
            if (!possible)
                break
        }

        if (possible)
            sum += count

        count ++
        possible = true
    }

    return sum
}

fun main() {

    val file1 = File("D:\\Polytech\\Bonus\\Kotlin\\advent-of-code\\src\\main\\kotlin\\eu\\bledanois\\day2\\input1.txt")

    println(part1(file1))
    println(part2(file1))
}

fun part2(file: File): Int {
    TODO("Not yet implemented")
}
