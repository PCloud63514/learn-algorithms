fun main() {
    val answer = solution(intArrayOf(6, 10, 2))
    println("answer:" + answer)
}

fun solution(numbers: IntArray): String {
    var array
    var data = 0
    for(i in 0..numbers.lastIndex) {
        val number = numbers.get(i)
        "[0-9]".toRegex().findAll(number.toString()).forEach { item ->
            if( data < item.value.toInt()) {

            }
        }
    }
    var answer = ""


    return answer
}