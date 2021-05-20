fun main() {
    var arr = Array<IntArray>(5) { intArrayOf(0) }
    arr.set(0, intArrayOf(5, 7, 9))
    arr.set(1, intArrayOf(4, 6, 4))
    arr.set(2, intArrayOf(3, 6, 1))
    arr.set(3, intArrayOf(3, 2, 3))
    arr.set(4, intArrayOf(2, 1, 6))
    // arr.set(5, intArrayOf(4,6,50))
    // arr.set(6, intArrayOf(2,4,66))
    // arr.set(7, intArrayOf(2,3,22))
    // arr.set(8, intArrayOf(1,6,25))

    println(Kakao2021Question4().solution(7, 3, 4, 1, arr))
}
/* 
플로이드 알고리즘 구현
정점에 대한 이동의 값을 구하는 알고리즘
1. 그래프를 2차원 배열로 만든다.
1-1. 자기자신에 대한 이동은 비용을 0으로 설정한다.
1-2. 연결되지 않은 경로는 그래프의 값보다 큰 값으로 설정한다. 이 과정에서 음수가 발생해서는 안된다.
2. 시작점 i, 끝점 j, 경유점 k를 계산해야한다.
3. floyd[i][j] = MIN(floyd[i,j], floyd[i][k] + floyd[k][j])
*/

class Kakao2021Question4 {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var graphArray = Array<IntArray>(n + 1) { IntArray(n + 1) { 99999999 }}

        for(i in graphArray.indices) {
            graphArray[i][i] = 0
        }


        fares.forEach { 
            println(it.joinToString(","))
            val i = it.get(0)
            val j = it.get(1)
            val cost = it.get(2)
            
            graphArray[i][j] = cost
            graphArray[j][i] = cost
        }

        for(k in 1..graphArray.lastIndex) {
            for(i in 1..graphArray.lastIndex) {
                for(j in 1..graphArray.lastIndex) {
                    graphArray[i][j] = Min(graphArray[i][j], graphArray[i][k] + graphArray[k][j])
                }
            }
        }
        var answer:Int = 99999999
        for(k in 1..n) {
            answer = Min(answer, graphArray[s][k] + graphArray[k][a] + graphArray[k][b])
        }
        return answer
    }

    fun Min(a:Int, b:Int):Int {
        return if(a <= b){a} else {b}
    }
}