fun main() {
    // Test case 1: Basic overlapping match
    fun testBasicOverlappingMatch() {
        val str = "ababa"
        val substr = "aba"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result == listOf(0, 2)) { "Failed testBasicOverlappingMatch: $result" }
    }

    // Test case 2: Circular overlapping match
    fun testCircularOverlappingMatch() {
        val str = "ababa"
        val substr = "bab"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result == listOf(1)) { "Failed testCircularOverlappingMatch: $result" }
    }

    // Test case 3: Exact match
    fun testExactMatch() {
        val str = "abcde"
        val substr = "abcde"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result == listOf(0)) { "Failed testExactMatch: $result" }
    }

    // Test case 4: No match at all
    fun testNoMatch() {
        val str = "abcde"
        val substr = "fgh"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result.isEmpty()) { "Failed testNoMatch: $result" }
    }

    // Test case 5: Case-sensitive match
    fun testCaseSensitiveMatch() {
        val str = "abABa"
        val substr = "ABA"
        val result = str.circularIndexesOfWithOverlap(substr, ignoreCase = false)
        check(result.isEmpty()) { "Failed testCaseSensitiveMatch: $result" }
    }

    // Test case 6: Case-insensitive match
    fun testCaseInsensitiveMatch() {
        val str = "abABa"
        val substr = "ABA"
        val result = str.circularIndexesOfWithOverlap(substr, ignoreCase = true)
        check(result == listOf(0, 2)) { "Failed testCaseInsensitiveMatch: $result" }
    }

    // Test case 7: Empty string and non-empty substring
    fun testEmptyStringAndNonEmptySubstring() {
        val str = ""
        val substr = "abc"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result.isEmpty()) { "Failed testEmptyStringAndNonEmptySubstring: $result" }
    }

    // Test case 8: Non-empty string and empty substring
    fun testNonEmptyStringAndEmptySubstring() {
        val str = "abcde"
        val substr = ""
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result.isEmpty()) { "Failed testNonEmptyStringAndEmptySubstring: $result" }
    }

    // Test case 9: Empty string and empty substring
    fun testEmptyStringAndEmptySubstring() {
        val str = ""
        val substr = ""
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result.isEmpty()) { "Failed testEmptyStringAndEmptySubstring: $result" }
    }

    // Test case 10: Substring longer than the string
    fun testSubstringLongerThanString() {
        val str = "abcde"
        val substr = "abcdefgh"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result.isEmpty()) { "Failed testSubstringLongerThanString: $result" }
    }

    // Test case 11: Complex overlapping match with circularity
    fun testComplexOverlappingMatchWithCircularity() {
        val str = "xyzxyzxyz"
        val substr = "xyzx"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result == listOf(0, 3, 6)) { "Failed testComplexOverlappingMatchWithCircularity: $result" }
    }

    // Test case 12: All indices match with single-character substring
    fun testAllIndicesMatchSingleCharacterSubstring() {
        val str = "aaaaa"
        val substr = "a"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result == listOf(0, 1, 2, 3, 4)) { "Failed testAllIndicesMatchSingleCharacterSubstring: $result" }
    }

    // Test case 13: Multiple overlapping matches across circular boundary
    fun testMultipleOverlappingMatchesAcrossCircularBoundary() {
        val str = "abcabc"
        val substr = "cabc"
        val result = str.circularIndexesOfWithOverlap(substr)
        check(result == listOf(2, 5)) { "Failed testMultipleOverlappingMatchesAcrossCircularBoundary: $result" }
    }

    // Run all tests
    testBasicOverlappingMatch()
    testCircularOverlappingMatch()
    testExactMatch()
    testNoMatch()
    testCaseSensitiveMatch()
    testCaseInsensitiveMatch()
    testEmptyStringAndNonEmptySubstring()
    testNonEmptyStringAndEmptySubstring()
    testEmptyStringAndEmptySubstring()
    testSubstringLongerThanString()
    testComplexOverlappingMatchWithCircularity()
    testAllIndicesMatchSingleCharacterSubstring()
    testMultipleOverlappingMatchesAcrossCircularBoundary()

    println("All tests passed!")
}
