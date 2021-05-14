class CombinationUtils {
    fun getSplitList(target:String):List<String> {
        var list:List<String> = target.split("")
        return list.subList(1, list.lastIndex)
    }
    
    fun combination(target:String, sizes:List<Int>):MutableList<String> {
        var mutableList:MutableList<String> = mutableListOf<String>()
        var combineList = getSplitList(target)
    
        var targetSize = sizes.filter { it <= target.length }
    
        targetSize.forEach {
            _combination(mutableList, combineList, Array<Boolean>(combineList.size){false}, it, 0)
        }
    
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
}
fun main() {
    var list : List<String> = listOf<String>("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH")
    var combinationUtils = CombinationUtils()
    for(i in 0..list.lastIndex) {
        var mutableList = combinationUtils.combination(list.get(i), arrayListOf(2,3,4))

        mutableList.forEach { 
            println(it)
        }
    }
}

