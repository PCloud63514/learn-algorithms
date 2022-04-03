import java.lang.Math.max
import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var queue: Queue<Int> = LinkedList<Int>()
        var graph = Array(n + 1) { BooleanArray(n + 1 ) { false } }
        var depths = IntArray(n + 1) {0}
        var maxDepth = 0

        for (i in edge.indices - 1) {
            graph[edge[i][0]][edge[i][1]] = true
            graph[edge[i][1]][edge[i][0]] = true
        }

        queue.add(1)

        while(queue.isNotEmpty()) {
            val node = queue.poll()
            for (i in 2..n) {
                if (depths[i] == 0 && graph[node][i]) {
                    depths[i] = depths[node] + 1
                    queue.add(i)
                    maxDepth = max(maxDepth, depths[i])
                }
            }
        }

        return depths.filter { it == maxDepth }.size
    }
}

fun main() {
    Solution().solution(6, arrayOf(intArrayOf(3, 6),
        intArrayOf(4, 3), intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(5, 2)))
}