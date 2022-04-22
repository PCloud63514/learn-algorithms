package org.pcloud

class Solution {
    fun solution(tstring: String, variables: Array<Array<String>>) : String {
        var tokens = mutableMapOf<String, String>()
        var answer = tstring
        for (i in variables.indices) {
            val col = variables[i]
            val text1 = col[0]
            val text2 = col[1]

            tokens.put(text1, text2)
        }

        val toRegex = "^[{]".toRegex()

        while (1 <= tokens.filter { it.value.contains(toRegex) }.size) {
            for (token in tokens.iterator()) {
                if (token.value.contains(toRegex)) {
                    val subToken = token.value.substring(1, token.value.length - 1)
                    tokens.put(token.key, tokens.get(subToken)!!)
                }
            }
        }

        for (token in tokens.iterator()) {
            answer = answer.replace("{${token.key}}", token.value)
        }

        return answer
    }
}

fun main() {
    Solution().solution("this is {template} {template} is {state}", arrayOf(arrayOf("template", "string"), arrayOf("state", "changed")))
}