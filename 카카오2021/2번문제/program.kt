// countMap.toList().sortedWith(compareBy({it.second})).toMap() 정렬 코드

// WX 랑 XW 안합쳐짐
fun main() {
    var list : Array<String> = arrayOf("XYZ", "XWY", "WXA")
    var course = arrayListOf(2, 3, 4)
    var answer:ArrayList<String> = ArrayList<String>()
    
    course.forEach { c ->
        var countMap:MutableMap<String,Int> = HashMap<String, Int>()
        for(i in 0..list.lastIndex) {
            // 길이가 c인 녀석들만 다 꺼냄
            var mutableList = combination(list.get(i), c)
            
            // 중첩 계산 함
            mutableList.forEach { key ->
                if(countMap.get(key) == null) {
                    countMap.set(key, 1)
                } else {
                    countMap.set(key, countMap.get(key)!! + 1)
                }
            }
        }
        countMap.forEach {
            println("key:" + it.key + "| value:" + it.value)
        }

        // 이 중 가장 중첩이 많이 된 녀석의 key를 answer에 추가함
        val maxValue = countMap.values.fold(0, { max, next ->
            if(max < next) next else max
        })
        if(maxValue > 1) {
            countMap.filter {entriy -> entriy.value == maxValue }.forEach {
                answer.add(it.key)
            }
        }
    }
    answer.sort()
    println(answer.toString())
}

fun getSplitList(target:String):List<String> {
    var list:List<String> = target.split("")
    return list.subList(1, list.lastIndex)
}

fun combination(target:String, size:Int):MutableList<String> {
    var mutableList:MutableList<String> = mutableListOf<String>()
    var combineList = getSplitList(target)

    _combination(mutableList, combineList, Array<Boolean>(combineList.size){false}, size, 0)
    
    return mutableList
}

fun _combination(cahceList:MutableList<String>, combineList:List<String>, checkB:Array<Boolean>, size:Int, start:Int=0) {
    if(size == 0) {
        val str = combineList.filterIndexed { index, _ -> checkB[index] }.joinToString("","","")
        cahceList.add(str)
    } else {
        for(i in start..combineList.lastIndex) {
            checkB[i] = true
            _combination(cahceList, combineList, checkB, size-1, i + 1)
            checkB[i] = false
        }
    }
}