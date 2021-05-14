// 코딩 테스트 참여 개발 언어 항목에 (cpp, java, python) 중 하나를 선택
// 지원 직군 항목에 backend or frontend  선택
// 지원 경력 구분 항목에 junior or senior 선택
// 선호하는 소울푸드로 chicken or pizza 선택

fun main() {
    var info:Array<String> = arrayOf<String>("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    var query:Array<String> = arrayOf<String>("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")

    solution(info, query)
}

fun solution(info:Array<String>, query:Array<String>):IntArray {
    var answer:IntArray = intArrayOf()
    var valunteerInfoList:ArrayList<VolunteerInfo> = ArrayList<VolunteerInfo>()
    var queryInfoList:ArrayList<VolunteerInfo> = ArrayList<VolunteerInfo>()

    VolunteerInfoRegister(valunteerInfoList, info)
    VolunteerInfoRegister(queryInfoList, query)

    // 4개의 조건 검사? 
    // 어차피 점수도 조건의 일종 전부 True가 나오면 통과라고 생각해야한다.
    // 결과의 경우 제시된 조건에 맞는 사람의 수를 고르는 것이다. 즉 중첩이 발생해도 상관 없다.
    // 지원 정보를 꺼내오고, 제시된 조건들에 전부 비교한다.
    // 맞은 조건과 같은 index의 answer의 값을 1 증가 시킨다.
    return answer
}

fun VolunteerInfoRegister(list:ArrayList<VolunteerInfo>,  registerInfo:Array<String>) {
    registerInfo.forEach {
        val splitInfoList:List<String> = it.split(' ')
        val queryInfo = VolunteerInfo(splitInfoList.get(0), splitInfoList.get(1), splitInfoList.get(2), splitInfoList.get(3))
        list.add(queryInfo)
    }
}

data class VolunteerInfo(val devLanguage:String, val jobGroup:String, val career:String, val soulFood:String)