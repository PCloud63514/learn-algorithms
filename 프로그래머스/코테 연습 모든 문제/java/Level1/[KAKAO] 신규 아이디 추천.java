/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */
class Solution {
    fun solution(new_id: String): String {
        var answer: String = new_id
        var regex = "[^a-z0-9\\.\\-\\_]".toRegex()

        answer = answer.toLowerCase()
        answer = regex.replace(answer, "")

        while(answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".")
        }

        answer = "^\\.|\\.$".toRegex().replace(answer,"")

        if(answer.isEmpty()) {
            answer = "a"
        }

        if(16 <= answer.length) {
            answer = answer.substring(0, 15)
            answer = "\\.$".toRegex().replace(answer, "")
        }

        if(2 >= answer.length) {
            var c = answer.last()
            while(answer.length != 3) {
                answer = answer.plus(c)
            }
        }

        return answer
    }
}