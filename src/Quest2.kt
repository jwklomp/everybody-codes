val symbols = listOf("OZZB", "SYW", "YH", "DHL", "BYET", "Y", "HGWA", "QSDGJKBQRF", "Q", "ROS", "U",
    "IID", "CU", "XR", "WOW", "AU", "XPX", "YN", "EJKEDSVIZE", "OL", "PUJ", "C",
    "L", "YAE", "FWEPNDYISN", "BMHQ", "RR", "PTOHXPBATB", "VHTHFMPQFD", "GW",
    "FBNO", "JSGO", "CJLFTYAKHG", "CN", "FAY", "FZFYBDDERL", "XY", "SRI", "VAKE",
    "EDRBZIZTSF", "DQEN", "VWBGQDHNBQ", "BUWQ", "OW", "XRUN", "KIS", "OO",
    "XTBCIBSZQG")

//val symbols = listOf("THE", "OWE", "MES", "ROD", "RODEO")


fun main() {
    fun part1(input: List<String>): Int {
        val result = input
            .first()
            .split(" ")
            .flatMap { word -> symbols.filter {symbol -> word.contains(symbol) } }
        println(result)
        return result.size
    }

    fun countRunicSymbols(runeWord: String): Int {
        println("runeWord: $runeWord")
        val allSymbols = symbols + symbols.map { it.reversed() }
        val allWordIndices = allSymbols.flatMap { symbol -> runeWord.indexesOfWithOverlap(symbol).map { i -> i..<i + symbol.length } }
        val numberOfSymbols = runeWord.indices.count { i -> allWordIndices.any { i in it } }
        println("numberOfSymbols: $numberOfSymbols")
        return numberOfSymbols
    }

    fun part2(input: List<String>): Int  {
        val result = input.flatMap {
            it.split(" ").map { runeWord -> countRunicSymbols(runeWord) }
        }.sum()
        return result
    }

    fun part3(input: List<String>): Int  {
        // Need to think of the input as a grid with x,y coordinates and for each coordinate, we need to check if it is part of a rune word

        // horizontal - process sentences one by one

        // vertical - transpose the grid and process sentences one by one

        val result = input.flatMap {
            it.split(" ").map { runeWord -> countRunicSymbols(runeWord) }
        }.sum()
        return result
    }

    val testInput = readInput("Quest2_test")
    //println(part1(testInput))
    //println(part2(testInput))
    println(part3(testInput))

    val input = readInput("Quest2")
    //println(part1(input))
    //println(part2(input))
    //println(part3(input))
}
