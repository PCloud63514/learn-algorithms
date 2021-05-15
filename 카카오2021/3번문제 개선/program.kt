import kotlin.system.*

fun main() {
    var info:Array<String> = arrayOf<String>("java backend junior pizza 150", "java backend junior pizza 150", "java backend junior pizza 150", "java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    var query:Array<String> = arrayOf<String>("java and backend and junior and pizza 500", "java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")


    // println("cpp and - and senior and pizza 250".split("( and )|( )".toRegex()).toString())
    val startTime:Long = measureTimeMillis  {
        Solutoin_kakao3().solution(info, query)
    }
    println(startTime)
}

class Solutoin_kakao3 {
    fun solution(info:Array<String>, query:Array<String>):IntArray {
        var answer:IntArray = IntArray(query.size) { 0 }
        val casesMap:MutableMap<VolunteerInfo, ArrayList<Int>> = HashMap<VolunteerInfo, ArrayList<Int>>()

        info.forEach {
            UpdateCases(casesMap, CreateVolunteerInfoInstanceAndScore(it))
        }

        // 정렬
        casesMap.forEach {
            it.value.sort()
        }

        for(i in 0..query.lastIndex) {
            val (queryInfo, score) = CreateVolunteerInfoInstanceAndScore(query.get(i))

            casesMap.get(queryInfo)?.let { list ->
                answer.set(i, answer.get(i) + list.filter { it >= score }.size)    
            }
            // 생각해보면 케이스에 없을 수도 있다. 지원자들이 아무도 Python을 안했는데 query에 Python이 있다면 당연히 없다
            // var index = list.binarySearch(score)
            
            //바이너리 서치로 점수와 일치하는 index를 찾는다
            //만약 index가 음수일 경우 lower bound를 사용하여 크거나 같은 값을 가진 요소의 인덱스를 찾는다.
            //list의 최대 갯수와 검색된 index를 뺸다.
            //answer[i] 위치의 값을 위의 값 만큼 증가시킨다.
        }

        return answer
    }

    fun CreateVolunteerInfoInstanceAndScore(data:String):Pair<VolunteerInfo, Int> {
        val splitInfoList:List<String> = data.split("( and )|( )".toRegex())//data.replace("and ", "").split(" ")
        val volunteerInfo:VolunteerInfo = VolunteerInfo(splitInfoList.get(0), splitInfoList.get(1), splitInfoList.get(2), splitInfoList.get(3))
        val score = splitInfoList.get(4).toInt()
        return Pair(volunteerInfo, score)
    }

    // 유저가 갖을 수 있는 모든 경우의 수를 입력한다.
    // 이 과정이 가장 길다 
    fun UpdateCases(cacheMap:MutableMap<VolunteerInfo, ArrayList<Int>>, pair:Pair<VolunteerInfo, Int>) {
        val (info, score) = pair
        val devLanguages = arrayOf(info.devLanguage, "-")        
        val jobGroups = arrayOf(info.jobGroup, "-")
        val careers = arrayOf(info.career, "-")
        val soulFoods = arrayOf(info.soulFood, "-")

        for(a in 0..devLanguages.lastIndex)
        for(b in 0..jobGroups.lastIndex)
        for(c in 0..careers.lastIndex)
        for(d in 0..soulFoods.lastIndex) {
            val vi = VolunteerInfo(devLanguages.get(a), jobGroups.get(b), careers.get(c), soulFoods.get(d))
            cacheMap.getOrPut(vi) { arrayListOf() }.add(score)
        }
    }
}
data class VolunteerInfo(val devLanguage:String, val jobGroup:String, val career:String, val soulFood:String)
