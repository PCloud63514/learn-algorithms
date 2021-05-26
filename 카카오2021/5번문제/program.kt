fun main() {
    println(Kakao2021Question5().solution("99:59:59", "25:00:00", 
        arrayOf<String>("69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00")))
}

/*
    log에서 시청자들의 누적 재생시간이 가장 많이 나오는 곳을 계산해 공익광고를 삽입하는 문제.
    공익광고가 들어갈 시작 시간을 구하면 된다
    단 최고 누적 재생시간이 겹친다면 가장 빠른 시작 시간을 기준으로 동작한다.

    단순히 누적 재생시간을 계산하는 것이라면 간단히 풀이될 수 있다
    입력에는 영상의 총 길이와 공익광고의 총 길이가 제공된다.
    공익 광고는 동영상의 길이보다 짧거나 같다.
*/

/* 광고 삽입 문제
    input
        - play_time:String = "02:03:55"
        - adv_time:String = "00:14:15"
        -logs:Array<String> = ["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]
    output
        - result:String = "01:30:59" */
class Kakao2021Question5 {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        val ptimeSec = ConvertSecond(play_time)
        val atimeSec = ConvertSecond(adv_time)

        val chaceArray:Array<Int> = Array<Int>(ptimeSec + 1) { 0 }

        for( i in logs.indices) {
            val slist = logs.get(i).split("-")
            val sSec= ConvertSecond(slist[0])
            val eSec= ConvertSecond(slist[1]) 

            chaceArray.set(sSec, chaceArray.get(sSec) + 1) 
            chaceArray.set(eSec, chaceArray.get(eSec) - 1)
        }

        for (i in 1..ptimeSec) {
            chaceArray.set(i, chaceArray.get(i) + chaceArray.get(i - 1))
        }

        var answerNum:Int = 0
        var answerIndex:Int = 0
        
        for(i in 1 until atimeSec) {
            answerNum += chaceArray.get(i)
        }
        var tempNum = answerNum

        for(i in atimeSec until ptimeSec) {
            answerNum = answerNum + chaceArray.get(i) - chaceArray.get(i-atimeSec)
            if (answerNum > tempNum) {
                tempNum = answerNum
                answerIndex = i - atimeSec + 1
            }
        }

        var answer = String.format("%02d:%02d:%02d", answerIndex / 3600, answerIndex / 60 % 60, answerIndex % 60)
        
        return answer
    }

    fun ConvertSecond(strTime:String):Int {
        val (t, m, s) = ConvertTime(strTime)
        return time2Second(t, m, s)
    }

    fun ConvertTime(strTime:String):Triple<Int,Int,Int> {
        val sl = strTime.split(":")
        return Triple(sl[0].toInt(), sl[1].toInt(), sl[2].toInt())
    }

    fun time2Second(time:Int, minute:Int, second:Int):Int {
        return (time * 60 * 60) + (minute * 60) + (second)
    }
}