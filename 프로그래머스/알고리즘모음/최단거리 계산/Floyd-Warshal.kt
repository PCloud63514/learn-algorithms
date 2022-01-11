fun main() {
    var arr = Array<IntArray>(9) { intArrayOf(0) }
    arr.set(0, intArrayOf(4,1,10))
    arr.set(1, intArrayOf(3,5,24))
    arr.set(2, intArrayOf(5,6,2))
    arr.set(3, intArrayOf(3,1,41))
    arr.set(4, intArrayOf(5,1,24))
    arr.set(5, intArrayOf(4,6,50))
    arr.set(6, intArrayOf(2,4,66))
    arr.set(7, intArrayOf(2,3,22))
    arr.set(8, intArrayOf(1,6,25))

    FloydWarshal().run(arr, 6, 4, 6)
}

class FloydWarshal {
    fun run(arr:Array<IntArray>, n:Int, s:Int, e:Int):Pair<IntArray, Int> {
        var graphArray = Array<IntArray>(n + 1) { IntArray(n + 1) { 999 }}

        for(i in graphArray.indices) {
            graphArray[i][i] = 0
        }

        arr.forEach { 
            val i = it.get(0)
            val j = it.get(1)
            val cost = it.get(2)
            
            graphArray[i][j] = cost
            graphArray[j][i] = cost
        }

        for(k in 1..graphArray.lastIndex) {
            for(i in 1..graphArray.lastIndex) {
                for(j in 1..graphArray.lastIndex) {
                    graphArray[i][j] = Min(graphArray[i][j], graphArray[i][k] + graphArray[k][j])
                }
            }
        }

        println(graphArray[s][e])

        for(i in graphArray.indices) {
            println("[${i}] " + graphArray.get(i).joinToString(", "))
        }
        return Pair(intArrayOf(), 0)
    }

    fun Min(a:Int, b:Int):Int {
        return if(a <= b){a} else {b}
    }
}