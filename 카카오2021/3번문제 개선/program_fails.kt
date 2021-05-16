import kotlin.system.*

fun main() {
    var info:Array<String> = arrayOf<String>("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    var query:Array<String> = arrayOf<String>("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")

    val startTime:Long = measureTimeMillis  {
        Solutoin_kakao3().solution(info, query)
    }
    println(startTime)
}

class Solutoin_kakao3 {
    val _INFO_SCORE_INDEX = 4
    val _INFO_SIZE = 4
    val _INFO_LAST_INDEX = 3
    fun solution(info:Array<String>, query:Array<String>):IntArray {
        var answer:IntArray = IntArray(query.size) { 0 }
        val casesMap:MutableMap<String, ArrayList<Int>> = HashMap<String, ArrayList<Int>>()

        info.forEach {
            UpdateCases(casesMap, it)
        }

        casesMap.forEach {
            it.value.sort()
        }

        val regex = "( and )|( )".toRegex()
        for(i in 0..query.lastIndex) {
            val repQuery = query.get(i).replace("-", "")
            val (queryInfo, score) = SplitTesterInfo(repQuery, regex)
            
            val item:List<String> = queryInfo.filter { !it.equals("") }
            val itemToString:String = if(item.size != 0) item.toString() else ""

            casesMap.get(itemToString)?.let { list ->
                answer.set(i, answer.get(i) + list.filter { it >= score }.size)    
            }
        }

        return answer
    }

    fun SplitTesterInfo(testerInfo:String, regex:Regex):Pair<List<String>, Int> {
        var infoList:List<String> = testerInfo.split(regex)
        val score = infoList.get(_INFO_SCORE_INDEX).toInt()
        return Pair(infoList.subList(0, _INFO_SIZE), score)
    }

    fun UpdateCases(casesMap:MutableMap<String, ArrayList<Int>>, info:String) {
        val regex = "( )".toRegex()
        var (infoList, score) = SplitTesterInfo(info, regex)
        // infoList = infoList.subList(0, _INFO_SIZE)

        for(i in 1..4) {
            DFS(casesMap, infoList, Array<Boolean>(_INFO_SIZE) { false }, i, score)
        }
        casesMap.getOrPut("") { arrayListOf() }.add(score)
    }

    fun DFS(casesMap:MutableMap<String, ArrayList<Int>>, infoList:List<String>, checkB:Array<Boolean>, maxDepth:Int, score:Int, start:Int=0) {
        if(maxDepth == 0) {
            val info = infoList.filterIndexed { i, _ -> checkB[i] }.toString()
            casesMap.getOrPut(info) { arrayListOf() }.add(score)
        } else {
            for(i in start..infoList.lastIndex) {
                checkB[i] = true
                DFS(casesMap, infoList, checkB, maxDepth - 1, score, i + 1)
                checkB[i] = false
            }
        }
    }
}
