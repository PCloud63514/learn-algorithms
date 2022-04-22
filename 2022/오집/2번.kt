package org.pcloud

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun solution(call: String) : String {
        var answer = call
        var callBuilder = StringBuilder(call)
        var keywords = mutableSetOf<Pair<String, Int>>()

        val toList = call.toList()

        for (i in toList.indices) {
            for (j in i + 1 until toList.size) {
                val keyword = call.substring(i, j)
                val count = getTokenCount(call, keyword)
                keywords.add(Pair(keyword.lowercase(), count))
            }
        }

        val sortedWith = keywords.sortedWith(compareBy({ -it.second }, { it.first.length }))
        val maxCount = sortedWith.first().second
        val maxCountList = sortedWith.filter { it.second == maxCount }
        var answerKeywords = arrayListOf<String>()



        for (i in maxCountList.indices) {
            answerKeywords.add(maxCountList[i].first)
            for (j in i until maxCountList.size) {
                if (i != j && maxCountList[j].first.contains(maxCountList[i].first)) {
                    answerKeywords.remove(maxCountList[i].first)
                }
            }
        }

        for (i in answerKeywords.indices) {
            answer = answer.replace(answerKeywords[i], "", true)
        }

        return answer
    }

    fun getTokenCount(call:String, token:String):Int {
        var count:Int = 0

        for (i in call.indices) {
            if (call.substring(i).startsWith(token)) {
                count++
            }
        }
        return count
    }
}

fun main() {
    Solution().solution("ABCabcA")
}