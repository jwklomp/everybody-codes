import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

fun String?.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> {
    return this?.let {
        val regex = if (ignoreCase) Regex(substr, RegexOption.IGNORE_CASE) else Regex(substr)
        regex.findAll(this).map { it.range.first }.toList()
    } ?: emptyList()
}

fun String?.indexesOfWithOverlap(substr: String, ignoreCase: Boolean = true): List<Int> {
    return this?.let {
        val regex = if (ignoreCase) Regex("(?=$substr)", RegexOption.IGNORE_CASE) else Regex("(?=$substr)")
        regex.findAll(this).map { it.range.first }.toList()
    } ?: emptyList()
}

fun String?.circularIndexesOfWithOverlap(substr: String, ignoreCase: Boolean = true): List<Int> {
    if (this == null || substr.isEmpty()) return emptyList()

    val sourceLength = this.length
    val searchLength = substr.length

    return (0 until sourceLength).filter { start ->
        (0 until searchLength).all { offset ->
            val circularIndex = (start + offset) % sourceLength
            this[circularIndex].equals(substr[offset], ignoreCase)
        }
    }
}
