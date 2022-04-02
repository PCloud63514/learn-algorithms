package org.pcloud

class Solution {
    fun solution(N: Int, number: Int): Int {
        dfs(N, number, 0, 0)
        return if (answer == 9) { -1 } else { answer }
    }
}
var answer: Int = 9
fun dfs(N: Int, number: Int, depth: Int, value: Int) {
    if (8 < depth) return
    if ((number == value) && (depth < answer))  { answer = depth }

    var X: Int = N
    for (i in 1..8) {
        dfs(N, number, i + depth, value + X)
        dfs(N, number, i + depth, value - X)
        dfs(N, number, i + depth, value * X)
        dfs(N, number, i + depth, value / X)
        X = (X * 10) + N
    }
}

fun main() {
    Solution().solution(5, 12)
    println(answer)
}