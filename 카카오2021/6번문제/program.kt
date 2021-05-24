
fun main() {
    var board = Array<IntArray>(4) { IntArray(4) { 0 }}

    board.set(0, intArrayOf(1,0,0,3))
    board.set(1, intArrayOf(2,0,0,0))
    board.set(2, intArrayOf(0,0,0,2))
    board.set(3, intArrayOf(3,0,1,0))

    println(Kakao2021Question6().solution(board, 1, 0))
}
class Kakao2021Question6 {
    fun solution(board: Array<IntArray>, r: Int, c: Int): Int {
        var answer: Int = 0
        return answer
    }
}