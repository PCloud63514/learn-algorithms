fun main() {
    // var board = Array<IntArray>(4) { IntArray(4) { 0 }}
    // board.set(0, intArrayOf(1,0,0,3))
    // board.set(1, intArrayOf(2,0,0,0))
    // board.set(2, intArrayOf(0,0,0,2))
    // board.set(3, intArrayOf(3,0,1,0))

    // println(Kakao2021Question6().solution(board, 1, 0))
    var board2 = Array<IntArray>(4) { IntArray(4) { 0 }}
    board2.set(0, intArrayOf(3,0,0,2))
    board2.set(1, intArrayOf(0,0,1,0))
    board2.set(2, intArrayOf(0,1,0,0))
    board2.set(3, intArrayOf(2,0,0,3))
    println(Kakao2021Question6().solution(board2, 0, 1))
}

/**
4x4 카드 뒤집기
1. 각 카드 위치 기록
2. A 카드에서 B 카드에 도착에 필요한 카운트 계산
3. 2번 과정을 모든 카드가 소모될 때까지 반복
4. 이를 모든 카드의 값에 관한 순열 순서로 반복한다
5. 가장 값이 낮은 결과를 반환
 */
class Kakao2021Question6 {
    /** get Cards */
    fun Cards(board:Array<IntArray>):Map<Int, List<Position>> {
        var cards:MutableMap<Int, ArrayList<Position>> = HashMap()
        for(row in 0 until 4) {
            for(col in 0 until 4) {
                if(board[row][col] != 0) {
                    val list = cards.getOrPut(board[row][col]) { ArrayList<Position>() }
                    list.add(Position(row, col))
                }
            }
        }
        return cards
    }

    /**
     * 도착 위치까지 필요한 최소 이동거리를 계산하는 로직
     * start : 현재 위치
     * end : 도착 위치
     * cnt : 이동 횟수
     * @return : move count
     */
    fun bfs(board: ArrayList<MutableList<Int>>, start:Position, end:Position):Int {
        val moveValues = ArrayList<IntArray>() // 상하좌우 이동 값 생성
        moveValues.add(intArrayOf(-1, 0))
        moveValues.add(intArrayOf(1, 0))
        moveValues.add(intArrayOf(0, -1))
        moveValues.add(intArrayOf(0, 1))

        val checkBoard:List<MutableList<Boolean>> = MutableList(4) { MutableList<Boolean>(4) { false } }
        val naviQ = arrayListOf<Recode>();
        naviQ.add(Recode(start, 0))
        while(!naviQ.isEmpty()) {

            val recode = naviQ.removeAt(0) // 큐에서 Recode 꺼냄
            // 도착했을 경우 값 반환
            if(recode.position.compare(end)) {
                return recode.cnt + 1 // +1은 Enter 선택 회수
            }
            // Recode 기준 상하좌우 및 컨트롤 상하좌우 검색
            for(i in moveValues.indices) {
                var moveRow = recode.position.row + moveValues.get(i)[0]
                var moveCol = recode.position.col + moveValues.get(i)[1]
                // 4x4 벽 끝인지 검사 벽 끝이면 패스
                if(BoardSizeException(moveRow, moveCol)) continue
                // 이동 후 위치가 처음 도착인지 검사. 처음 이동 시 Queue에 Recode 추가
                if(checkBoard[moveRow][moveCol] == false) {
                    checkBoard[moveRow][moveCol] = true
                    naviQ.add(Recode(Position(moveRow, moveCol), recode.cnt + 1))
                }

                // 컨트롤 키 이동 (최대 4x4 공간이고, 이미 위에서 1칸 이동했기 때문에 최대 이동할 수 있는 거리는 2)
                for(j in 0 until 2) {
                    // 위치에 카드가 있다면 break (카드가 있다면 컨트롤 키 이동을 할 수 없기 때문)
                    if(board[moveRow][moveCol] != 0) break
                    // 4x4 벽 끝인지 검사
                    if(BoardSizeException(moveRow + moveValues.get(i)[0] , moveCol  + moveValues.get(i)[1])) break
                    moveRow += moveValues.get(i)[0]
                    moveCol += moveValues.get(i)[1]
                }

                if(checkBoard[moveRow][moveCol] == false) {
                    checkBoard[moveRow][moveCol] = true
                    naviQ.add(Recode(Position(moveRow, moveCol), recode.cnt + 1))
                }
            }
        }
        return 999999
    }

    /** 범위에서 벗어났을 경우 에러(true) */
    fun BoardSizeException(row:Int, col:Int):Boolean {
        if(row < 0 || row > 3 || col < 0 || col > 3) {
            return true
        }
        return false
    }

    /**
     * board:Array<IntArray> = 게임 판
     * r:Int = 시작 위치(행-row)  0 ~ 3
     * c:Int = 시작 위치(열-column)  0 ~ 3
     * result 입력 수
     */
    fun solution(board: Array<IntArray>, r: Int, c: Int): Int {
        var tempBoard = ArrayList<MutableList<Int>>()
        board.forEach {
            tempBoard.add(it.toMutableList())
        }
        return navigation(tempBoard, Position(r, c))
    }

    fun navigation(board: ArrayList<MutableList<Int>>, currentCard:Position):Int {
        //최대 6장의 카드가 존재하므로 1 ~ 6
        var ret = 999999
        for(i in 1..6) {
            var cards = ArrayList<Position>()
            //4x4 영역에서 i 번째 카드 갖고오기
            for(row in 0..3) {
                for(col in 0..3) {
                    if(board[row][col] == i) {
                        cards.add(Position(row, col))
                    }
                }
            }

            if (cards.isEmpty()) continue

            //Current 부터 방금 꺼낸 카드까지의 이동 거리를 계산. 단 i 번째 카드는 총 2장이므로 순서를 바꿔서도 계산
            var A = bfs(board, currentCard, cards.get(0)) + bfs(board, cards.get(0), cards.get(1))
            var B = bfs(board, currentCard, cards.get(1)) + bfs(board, cards.get(1), cards.get(0))

            board[cards.get(0).row][cards.get(0).col] = 0
            board[cards.get(1).row][cards.get(1).col] = 0

            // 둘 중 뭐가 더 작은지 계산
            ret = Math.min(ret, A + navigation(board, cards.get(1)))
            ret = Math.min(ret, B + navigation(board, cards.get(0)))

            board[cards.get(0).row][cards.get(0).col] = i
            board[cards.get(1).row][cards.get(1).col] = i
        }

        if(ret == 999999) {
            return 0
        }

        return ret
    }
}

data class Recode(val position:Position, val cnt:Int)
/**
 * @row
 * @col
 * @value
 * @cnt
 */
data class Position(val row:Int, val col:Int) { fun compare(position:Position):Boolean { return row == position.row && col == position.col} }