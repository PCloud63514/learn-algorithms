

import kotlin.collections.listOf// countMap.toList().sortedWith(compareBy({it.second})).toMap() 정렬 코드


fun main() {
    println(listOf(3,3,3,3,3,3,3).binarySearch(3))
    // for(i in 0 until (1 shl 4)) {
    //     println("i:" + i)
    //     for(j in 0 until 4) {
    //         if (i and (1 shl j) != 0) {
    //             println("j:" + j)
    //         }
    //     }
    //     println("==================end")
    // }
}