package org.pcloud

class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for (i in left..right) {
            var divisorCount = 1
            for (j in 1..i / 2) {
                if (i % j == 0) {
                    divisorCount++
                }
            }
            answer = when {
                divisorCount % 2 == 0 -> answer + i
                else -> answer - i
            }
        }

        return answer
    }
}

fun main() {
    Solution().solution(13, 17)
}