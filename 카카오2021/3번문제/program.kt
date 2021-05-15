fun main() {
    var info:Array<String> = arrayOf<String>("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    var query:Array<String> = arrayOf<String>("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")

    solution(info, query)
}

fun solution(info:Array<String>, query:Array<String>):IntArray {
    var answer:IntArray = IntArray(query.size)
    var valunteerInfoList:ArrayList<VolunteerInfo> = ArrayList<VolunteerInfo>()
    var queryInfoList:ArrayList<VolunteerInfo> = ArrayList<VolunteerInfo>()

    VolunteerInfoRegister(valunteerInfoList, info)
    VolunteerInfoRegister(queryInfoList, query)

    for(i in 0..queryInfoList.lastIndex) {
        valunteerInfoList.forEach {
            if(compare(it, queryInfoList.get(i))) {
                answer.set(i, answer.get(i) + 1)
            }
        }
    }
    answer.forEach {
        println(it)
    }
    return answer
}

fun VolunteerInfoRegister(list:ArrayList<VolunteerInfo>,  registerInfo:Array<String>) {
    registerInfo.forEach {
        val splitInfoList:List<String> = it.replace("and ", "").split(" ")
        val queryInfo = VolunteerInfo(splitInfoList.get(0), splitInfoList.get(1), splitInfoList.get(2), splitInfoList.get(3),  splitInfoList.get(4).toInt())
        list.add(queryInfo)
    }
}

fun compare(volunteerInfo:VolunteerInfo, queryInfo:VolunteerInfo):Boolean {
    return ((queryInfo.devLanguage == "-" || volunteerInfo.devLanguage == queryInfo.devLanguage) &&
    ( queryInfo.jobGroup == "-" || volunteerInfo.jobGroup == queryInfo.jobGroup) &&
    (queryInfo.career == "-" || volunteerInfo.career == queryInfo.career) &&
    (queryInfo.soulFood == "-" || volunteerInfo.soulFood == queryInfo.soulFood) &&
    (volunteerInfo.score >= queryInfo.score))
}

data class VolunteerInfo(val devLanguage:String, val jobGroup:String, val career:String, val soulFood:String, val score:Int)