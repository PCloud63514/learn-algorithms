class CombinationsClass {
    /** 순차 순열
     * @chace : 순열 결과를 저장할 배열
     * @list : 가져올 배열
     * @r : 가져올 개수
     * @start : 현재 위치
     * @visited : 꺼냈는지 여부
     * 
     * ex) 1,2,3,4 입력 r=3
     * 1,2,3 | 1,2,4 | 1,3,4 | 2,3,4
     */
    fun SequentialCombination(chace:ArrayList<List<Int>>, list:List<Int>, r:Int, start:Int=0, visited:MutableList<Boolean>) {
        if(r == 0) { 
            chace.add(list.filterIndexed { index, _ -> visited[index] })
            return
        }
        for(i in start..list.lastIndex) {
            visited[i] = true
            SequentialCombination(chace, list, r - 1, i + 1, visited)
            visited[i] = false
        }
    }

    /** 순서중복순열
     * @chace : 결과를 저장할 배열
     * @list : 값을 가져올 배열
     * @r : list에서 가져올 요소의 갯수
     * 
     * ex) 1,2,3 ... 2,1,3 | 2,1,4 .. 4,3,1 | 4,3,2
     */
    fun Combination(chace:ArrayList<List<Int>>, list:List<Int>, r:Int) {
        var visited = MutableList(list.size) { false }
        var temp = ArrayList<Int>()
        _combination(
            chace=chace, 
            list=list, 
            r=r,
            temp=temp,
            visited=visited)
    }
    /** Combination 내부 로직 */
    private fun _combination(chace:ArrayList<List<Int>>, list:List<Int>, r:Int, temp:ArrayList<Int>, visited:MutableList<Boolean>) {
        if(r == 0) {
            chace.add(temp.clone() as List<Int>)
        }
        for(i in 0..list.lastIndex) {
            if(visited[i] == false) {
                visited[i] = true
                temp.add(list[i])
                _combination(chace, list, r-1, temp, visited)
                visited[i] = false
                temp.removeAt(temp.lastIndex)
            }
        }
    }
}

fun main() {
    var chace = ArrayList<List<Int>>()
    var list = ArrayList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    CombinationsClass().Combination(chace, list, 3)
    chace.forEach {
        println(it.toString())
    }
}