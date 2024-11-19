fun main() {
    fun part1(input: List<String>): Int {
        val result = input.map { it.split(",") }
        println(result)
        return 1
    }

    fun part2(input: List<String>): Int  {
        val result = input.map { it.split(",") }
        println(result)
        return 1
    }

    fun part3(input: List<String>): Int  {
        val result = input.map { it.split(",") }
        println(result)
        return 1
    }

    val testInput = readInput("QuestXX_test")
    println(part1(testInput))
    //println(part2(testInput))
    //println(part3(testInput))

    val input = readInput("QuestXX")
    //println(part1(input))
    //println(part2(input))
    //println(part3(input))
}
