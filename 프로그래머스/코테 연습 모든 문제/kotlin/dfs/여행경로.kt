package org.pcloud

class Solution {
    /**
     * 배열 정렬 방법
     * sort() :
     * sortBy() : 정렬 대상 배열의 요소가 n + 1개의 데이터 타입으로 이루어 졌을 때 하나의 요소를 선택하여 정렬하는 방식. Mutable List 에 사용.
     * sortedBy() : 정렬 대상 배열의 요소가 n + 1개의 데이터 타입으로 이루어 졌을 때 하나의 요소를 선택하여 정렬하는 방식. Immutable List에 사용.
     * ex) tickets.sortBy { it[0] }
     * sortWith() :  Comparator를 사용하여 정렬 규칙을 설정하는 방식. Mutable List에 사용한다.
     * sortedWith(): Comparator를 사용하여 정렬 규칙을 설정하는 방식. Immutable List에 사용한다.
     * ex) tickets.sortWith(compareBy({ it[0] }, { it[1] }))   <= 우선 선언된 comparator를 기준으로 정렬  (문자열 정렬 시 기본적으로 ASCII 값 사용)
     *
     * sortDescending : 내림차순 정렬
     */
    fun solution(tickets: Array<Array<String>>): Array<String> {
        tickets.sortWith(compareBy({ it[0] }, { it[1] }))

        dfs(tickets, 0, "ICN", Array<Boolean>(tickets.size + 1) { false }, Array<String>(tickets.size + 1) { "" })
        return answer
    }
}

var answer: Array<String> = emptyArray()

fun dfs(list: Array<Array<String>>, depth: Int, target: String, checks: Array<Boolean>, result: Array<String>) {
    if (answer.isNotEmpty()) { return }
    if (list.size == depth) {
        result[depth] = target
        answer = result
    } else {
        for (i in list.indices) {
            if (!checks[i] && target == list[i][0]) {
                val item = list[i]
                val start = item[0]
                val end = item[1]
                checks[i] = true
                result[depth] = start
                dfs(list, depth + 1, end, checks.clone(), result.clone())
                checks[i] = false
                result[depth] = ""
            }
        }
    }
}

fun main() {
    Solution().solution(
        arrayOf(
            arrayOf("ICN", "SFO"),
            arrayOf("ICN", "ATL"),
            arrayOf("SFO", "ATL"),
            arrayOf("ATL", "ICN"),
            arrayOf("ATL", "SFO")
        )
    )
}