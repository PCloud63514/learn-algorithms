package org.pcloud

class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        var list: IntArray = numbers.toList().map { it.digitToInt() }.toIntArray()
        dfs(list, BooleanArray(list.size) { false }, 0)


        val q = numberSets.toList()

        for (i in q.indices) {
            for (j in 2..q[i] / 2) {
                if (q[i] % j == 0) {
                    break
                }
            }
            answer++
        }

        return answer
    }
}

var numberSets = mutableSetOf<Int>()

fun dfs(numbers: IntArray, checks: BooleanArray, value: Int) {
    if (1 < value) {
        numberSets.add(value)
    }

    for (i in numbers.indices) {
        if (!checks[i]) {
            checks[i] = true
            dfs(numbers, checks.clone(), (value * 10) + numbers[i])
            checks[i] = false
        }
    }
}

fun main() {
    Solution().solution("17")
}