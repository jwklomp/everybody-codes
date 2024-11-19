val letterMapping = listOf("x", "A", "B", "C", "D")
val valuesMapping = listOf(0, 0, 1, 3, 5)

fun letterToValue(letter: String): Int = valuesMapping[letterMapping.indexOf(letter)]

fun powerUpLetterToValue(letters: List<String>): Int =
    letterToValue(letters.first()) + letterToValue(letters.last()) + (if(letters.contains("x")) 0 else 2)

fun powerUpThreeLetterToValue(letters: List<String>): Int =
    letterToValue(letters.first()) + letterToValue(letters[1]) + letterToValue(letters.last()) + if(letters.none { it == "x" }) 6 else if(letters.filter { it == "x" }.size == 1) 2 else 0

fun main() {
    fun part1(input: List<String>): Int {
        return input.first().split("").filter { it !== "" }.sumOf { letterToValue(it) }
    }

    fun part2(input: List<String>): Int  {
        return input.first().split("").filter { it !== "" }.chunked(2).sumOf { powerUpLetterToValue(it) }
    }

    fun part3(input: List<String>): Int  {
        return input.first().split("").filter { it !== "" }.chunked(3).sumOf { powerUpThreeLetterToValue(it) }
    }

    val testInput = readInput("Quest_test")
    //println(part1(testInput))
    //println(part2(testInput))
    println(part3(testInput))

    val input = readInput("Quest1")
    //println(part1(input))
    //println(part2(input))
    println(part3(input))
}
