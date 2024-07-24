package eu.bledanois.day2

import java.io.File

const val red = 12
const val green = 13
const val blue = 14


fun part1(file: File): Pair<Int, Int> {
    var sum = 0
    var sum1 = 0
    var count = 1
    var possible = true

    file.readLines().forEach { line ->
        val firstSplit = line.split(":")
        val sets = firstSplit.last()

        val setList = sets.split(";")

        var maxRed = 0
        var maxGreen = 0
        var maxBlue = 0

        for (set in setList) {
            val balls = set.split(",")

            for (ball in balls) {
                val number = ball.split(" ")[1]
                val color = ball.split(" ").last()

                when(color) {
                    "red" -> {
                        if (number.toInt() > red) possible= false
                        if (maxRed < number.toInt()) maxRed = number.toInt()
                    }
                    "green" -> {
                        if (number.toInt() > green) possible= false
                        if (maxGreen < number.toInt()) maxGreen = number.toInt()
                    }
                    "blue" -> {
                        if (number.toInt() > blue) possible= false
                        if (maxBlue < number.toInt()) maxBlue = number.toInt()
                    }
                }
            }
        }



        if (possible)
            sum += count

        sum1 += (maxRed * maxGreen * maxBlue)

        count ++
        possible = true
    }

    return Pair(sum, sum1)
}

fun main() {

    val file1 = File("src/main/kotlin/eu/bledanois/day2/input1.txt")

    println(part1(file1))
}

