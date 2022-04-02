package org.pcloud

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var errorRates = Array<FloatArray>(N) { FloatArray(2) { 0.0f } }
        var answer = Array<Int>(N) { 0 }

        var totalUserCount = stages.size.toFloat()

        for (i in 1 until N + 1 step 1) {
            val count = stages.count { it == i }.toFloat()
            errorRates[i - 1][0] = i.toFloat();
            if (count != 0.0f) {
                errorRates[i - 1][1] = count / totalUserCount
            }
            totalUserCount -= count;
        }

        errorRates.sortWith(compareBy({ it[1] }, { -it[0] }))
        errorRates.reverse()

        errorRates.forEachIndexed { index, floats ->
            answer[index] = floats[0].toInt()
        }
        return answer.toIntArray()
    }
}

fun main() {
    Solution().solution(3, intArrayOf(1, 1, 1))
//    val answer1 = Solution().solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3))
    Solution().solution(4, intArrayOf(4, 4, 4, 4, 4))
}