package eu.bledanois.day4

import eu.bledanois.Utils

fun main() {

    println(part1(Utils.readFile("src/main/kotlin/eu/bledanois/day4/input1.txt")))
}

fun part1(lines: List<String>): Int {
    var sum = 0

    lines.forEach { line ->
        val game = line.split(":")[1]
        var first = true
        var points = 0

        val winningNumberStr= game.split("|").first()
        val myNumberStr= game.split("|").last()

        val winningNumbers = mutableListOf<String>()
        val myNumbers = mutableListOf<String>()

        winningNumberStr.split(" ").forEach {
            if (it.isNotEmpty())
                winningNumbers.add(it)
        }

        myNumberStr.split(" ").forEach {
            if (it.isNotEmpty())
                myNumbers.add(it)
        }

        winningNumbers.forEach {
            if (myNumbers.contains(it)) {
                if (first) {
                    first = false
                    points = 1
                } else
                    points *= 2
            }
        }

        first = true
        sum += points
        points = 0
    }

    return sum
}

fun part2(lines: List<String>): Int {
    var sum = 0

    val games = mutableListOf<Pair<List<String>, List<String>>>()



    lines.forEach { line ->
        val game = line.split(":")[1]

        val winningNumberStr= game.split("|").first()
        val myNumberStr= game.split("|").last()

        val winningNumbers = mutableListOf<String>()
        val myNumbers = mutableListOf<String>()

        winningNumberStr.split(" ").forEach {
            if (it.isNotEmpty())
                winningNumbers.add(it)
        }

        myNumberStr.split(" ").forEach {
            if (it.isNotEmpty())
                myNumbers.add(it)
        }

        games.add(Pair(winningNumbers, myNumbers))
    }

    val map = mutableListOf<Int>()

    for (i in lines.indices) {
        map.add(1)
    }

    return sum
}

