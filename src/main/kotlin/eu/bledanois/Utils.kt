package eu.bledanois

import java.io.File

class Utils {

    companion object {
        fun readFile(path: String): List<String> = File(path).readLines()
    }
}