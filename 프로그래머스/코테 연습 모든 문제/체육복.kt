package org.pcloud

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var students = Array<Int>(n + 2) { 0 };
        students[0]--;
        students[n+1]--;

        reserve.forEach {
            students[it]++;
        }

        lost.forEach {
            students[it]--;
        }

        for(i in 1 until n + 1 step 1) {
            if (students[i] == -1) {
                if (students[i - 1] == 1) {
                    students[i - 1]--;
                    students[i]++;
                    continue;
                }
                if (students[i + 1] == 1) {
                    students[i + 1]--;
                    students[i]++;
                    continue;
                }
            }
        }

        val answer = students.filter { 0 <= it }.size

        return answer
    }
}

fun main() {
    val answer1 = Solution().solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5))
    val answer2 = Solution().solution(5, intArrayOf(2, 4), intArrayOf(3))
    val answer3 = Solution().solution(3, intArrayOf(3), intArrayOf(1))

    assert(answer1 == 5)
    assert(answer2 == 4)
    assert(answer3 == 2)
}