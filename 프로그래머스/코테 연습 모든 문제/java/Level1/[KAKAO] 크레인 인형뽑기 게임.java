import java.util.*

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val basket = Stack<Int>()
        val pang = { x: Int, y:Int -> x==y }

        for(m in moves) {
            val move = m.minus(1)
            for(grid in board) {
                if (grid[move] != 0) {
                    if (basket.isNotEmpty() && pang(basket.peek(), grid[move])) {
                        basket.pop()
                        answer = answer.plus(2)
                    } else {
                        basket.push(grid[move])
                    }
                    grid[move] = 0
                    break
                }
            }
        }
        return answer
    }
}