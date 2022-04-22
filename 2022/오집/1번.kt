package org.pcloud

class Solution {
    fun solution(path: String): Array<String> {
        var answer: ArrayList<String> = arrayListOf<String>()
        var directions = Array<Array<String>>(4) { Array<String>(4) { "" } }
        var arrows = mapOf(Pair('E', 0), Pair('W', 1), Pair('S', 2), Pair('N', 3))
        directions[0] = arrayOf( "", "" , "right", "left")
        directions[1] = arrayOf( "", "" , "left", "right")
        directions[2] = arrayOf( "left", "right" , "", "")
        directions[3] = arrayOf( "right", "left" , "", "")

        var totalTime = 0
        var pathLog = StringBuilder(path)

        while (pathLog.isNotEmpty()) {
            val c = pathLog.first()

            var range = 0
            val toList = pathLog.toList()
            for (i in toList.indices) {
                if (toList[i] != c) {
                    range = i
                    break
                }
            }
            if (range == 0) {
                break
            }

            pathLog.delete(0, range)

            val _range = range - 5

            if (0 < _range) {
                totalTime += _range
                range -= _range
            }

            val nextC = pathLog.firstOrNull()
            if (nextC != null) {
                answer.add("Time $totalTime: Go straight ${range * 100}m and turn ${directions[arrows[c]!!][arrows[nextC]!!]}")
                totalTime += range
            }
        }
        return answer.toTypedArray()
    }
}

fun main() {
    Solution().solution("EEESEEEEEENNNN")
}