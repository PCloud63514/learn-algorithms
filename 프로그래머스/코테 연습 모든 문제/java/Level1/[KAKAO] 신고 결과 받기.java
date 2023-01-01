import java.util.*

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size)

        var reportDB = Collections.emptyMap<String, MutableSet<Int>>().toMutableMap()

        report.forEach {
            val token = it.split(" ")
            val issuer = token[0]
            val target = token[1]

            if (!reportDB.containsKey(target))
                reportDB[target] = Collections.emptySet<Int>().toMutableSet()
            reportDB[target]!!.add(id_list.indexOf(issuer))
        }

        reportDB.forEach { key, value ->
            if (k <= value.size) {
                value.map { answer[it]++ }
            }
        }
        return answer
    }
}