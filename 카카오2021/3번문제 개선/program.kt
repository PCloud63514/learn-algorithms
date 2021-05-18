import kotlin.system.*

fun main() {
    for(i in  2 downTo 0) {
        println(i)
    }
    // var info:Array<String> = arrayOf<String>("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    // var query:Array<String> = arrayOf<String>("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and frontend and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")

    // val startTime:Long = measureTimeMillis  {
    //     Kakao2021Question3().solution(info, query)
    // }
    // println(startTime)
}

class Kakao2021Question3 {
    fun solution(info:Array<String>, query:Array<String>):IntArray {
        var answer:IntArray = IntArray(query.size) { 0 }
        var wordMap:MutableMap<String, Int> = SettingWordMap()
        var scoreList:MutableList<MutableList<Int>> = MutableList<MutableList<Int>>(4*3*3*3) { mutableListOf() }
        val infoRegex = " ".toRegex()
        val queryRegex = "( and )|( )".toRegex()

        info.forEach {
            val (infoList, score) = SplitInfo(it, infoRegex)
            val arr:IntArray = intArrayOf(
                wordMap.get(infoList.get(0))!! * 3 * 3 * 3,
                wordMap.get(infoList.get(1))!! * 3 * 3,
                wordMap.get(infoList.get(2))!! * 3,
                wordMap.get(infoList.get(3))!!)

            for(i in  0 until (1 shl 4)) {
                var index:Int = 0
                for(j in 0 until 4) {
                    if(i and (1 shl j) != 0) {
                        index += arr[j]
                    }
                }
                scoreList.get(index).add(score)
            }
        }

        scoreList.forEach {
            it.sort()
        }

        for(i in query.indices) {
            val(queryInfo, score) = SplitInfo(query.get(i), queryRegex)
            val index:Int = 
                (wordMap.get(queryInfo.get(0))!! * 3 * 3 * 3 +
                wordMap.get(queryInfo.get(1))!! * 3 * 3 +
                wordMap.get(queryInfo.get(2))!! * 3 +
                wordMap.get(queryInfo.get(3))!!)
                
            var ret:Int = scoreList.get(index).binarySearch(score)
            if (ret < 0) {
                ret = (ret + 1) * -1
            } else if(ret > 0) {
                for(j in ret downTo 0) {
                    if(scoreList.get(index).get(j) == score) {
                        ret = j
                    } else {
                        break
                    }
                }
            }
            answer.set(i, answer.get(i) + (scoreList.get(index).size - ret))
        }

        return answer
    }

    fun SettingWordMap():MutableMap<String, Int> {
        var wordMap:MutableMap<String, Int> = HashMap<String, Int>()
        wordMap.put("-",            0)
        wordMap.put("cpp",          1)
        wordMap.put("java",         2)
        wordMap.put("python",       3)
        wordMap.put("backend",      1)
        wordMap.put("frontend",     2)
        wordMap.put("junior",       1)
        wordMap.put("senior",       2)
        wordMap.put("chicken",      1)
        wordMap.put("pizza",        2)
        
        return wordMap
    }

    fun SplitInfo(info:String, regex:Regex):Pair<List<String>, Int> {
        var infoList:List<String> = info.split(regex)
        val score = infoList.get(4).toInt()
        return Pair(infoList.subList(0, 4), score)
    }
}