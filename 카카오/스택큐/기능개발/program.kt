import kotlin.math.*

fun main() {
    val answer:IntArray = solution(intArrayOf(99, 90, 99, 99, 80, 99), intArrayOf(10, 1, 1, 1, 1, 1))
    answer.forEach { item -> println(item) }
}

fun solution(progresses:IntArray, speeds:IntArray):IntArray {
    var answer = ArrayList<Int>()
    var workday:Int = 0

    for(i in 0..progresses.lastIndex) {
        val item = progresses.get(i)
        val isEnd = (workday * speeds.get(i)) + item >= 100

        if(isEnd) {
            val currentIndex = answer.lastIndex
            answer.set(currentIndex, answer.get(currentIndex) + 1)
        } else {
            workday = (ceil((100.0f - item) / speeds.get(i)).toInt())
            answer.add(1)
        }
    }

    return answer.toIntArray()
}