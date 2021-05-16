import kotlin.system.*

fun main() {
    for(i in 1..(1 shl 4)) {
        println(i)
    }
    // var info:Array<String> = arrayOf<String>("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    // var query:Array<String> = arrayOf<String>("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")

    // val startTime:Long = measureTimeMillis  {
    //     Solutoin_kakao3().solution(info, query)
    // }
    // println(startTime)
}

class Kakao2021Question3 {
    fun solution(info:Array<String>, query:Array<String>):IntArray {
        var answer:IntArray = IntArray(query.size) { 0 }
        var wordMap:MutableMap<String, Int> = SettingWordMap()

        val regex = " ".toRegex()

        info.forEach {
            val (infoList, score) = SplitInfo(it, regex)
            val arr:IntArray =   intArrayOf(
                wordMap.get(infoList.get(0))!!,
                wordMap.get(infoList.get(1))!!,
                wordMap.get(infoList.get(2))!!,
                wordMap.get(infoList.get(3))!!)


            
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
        wordMap.put("jonior",       1)
        wordMap.put("senior",       2)
        wordMap.put("chicken",      1)
        wordMap.put("pizza",        2)
        
        return wordMap
    }

    fun SplitInfo(info:String, regex:Regex):Pair<List<String>, Int> {
        var infoList:List<String> = info.split(regex)
        val score = infoList.get(4).toInt()
        return Pair(infoList.subList(0, 3), score)
    }
}