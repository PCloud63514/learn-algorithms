fun main() {
    val regex = """\W+""".toRegex()

    val list : List<String> = regex.split("abc abc abc abc")

    list.forEach {
        println(it)
    }
    // for(i in 1..list.size) {
    //     var mutableList:MutableList<List<String>> = mutableListOf<List<String>>()
        
    //     combination(mutableList, list, i, Array<Boolean>(list.size) { false })

    //     mutableList.forEach { 
    //         println(it)
    //     }
    // }

    // val answer = solution(arrayOf<String>("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2,3,4))
    // println(answer)
}

fun combination(list:MutableList<List<String>>, combineList:List<String>, size:Int, checkB:Array<Boolean>, start:Int=0) {
    if(size == 0) {
        list.addAll( listOf(combineList.filterIndexed { index, _ -> checkB[index] }) )
    } else {
        for(i in start..combineList.lastIndex) {
            checkB[i] = true
            combination(list, combineList, size-1, checkB, start + 1)
            checkB[i] = false
        }
    }
}



// fun solution(orders: Array<String>, course: IntArray): Array<String> {
//     var answer: Array<String> = arrayOf<String>()

//     for(i in 0..orders.lastIndex) {
//         var arr:List<String> = orders.get(i).split("")
        
//         arr.forEach { 

//         }

//     }
//     return answer
// }