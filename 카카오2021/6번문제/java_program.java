import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int[][] test2 = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};

        System.out.println(solution.solution(test1, 1, 0));
        System.out.println(solution.solution(test2, 0, 1));
    }
}

class Solution {
    class Position {
        int row, col, cnt;
        public Position(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
    int[][] Board;
    static final int INF = 987654321;
    static final int[][] D = {{-1, 0}, {1,0}, {0, -1}, {0, 1}}; // 상하좌우
    int permutate(Position position) {
        int ret = INF;
        // 카드를 찾음
        for(int num = 1; num <=6; ++num) {
            List<Position> card = new ArrayList<>();
            for(int i = 0; i < 4; ++i) {
                for(int j = 0; j < 4; ++j) {
                    if(Board[i][j] == num) {
                        card.add(new Position(i, j, 0));
                    }
                }
            }
            //카드가 없으면 패스
            if(card.isEmpty()) continue;
            // 카드 세트 중 첫 번째 부터 시작
            int one = bfs(position, card.get(0)) + bfs(card.get(0), card.get(1)) + 2;
            // 카드 세트 중 두 번째 부터 시작
            int two = bfs(position, card.get(1)) + bfs(card.get(1), card.get(0)) + 2;
            // 카드 짝을 맞추었으므로, Board 에서 카드 제거
            for(int i = 0; i < 2; ++i) {
                Board[card.get(i).row][card.get(i).col] = 0;
            }
            //재귀
            ret = Math.min(ret, one + permutate(card.get(1)));
            ret = Math.min(ret, two + permutate(card.get(0)));

            // 카드 복구
            for(int i = 0; i < 2; ++i) {
                Board[card.get(i).row][card.get(i).col] = num;
            }
        }
        if(ret == INF) {
            return 0;
        }
        return ret;
    }

    /**
     * 이동 카운팅을 계산하는 로직
     * @param src : 시작 위치
     * @param dst : 종료 위치
     * @return : 이동 카운팅
     */
    private int bfs(Position src, Position dst) {
        // 보드판 덤프 생성
        boolean[][] visited = new boolean[4][4];
        Queue<Position> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()) {
            //Queue 에서 값 꺼냄.
            Position cur = queue.poll();
            // 종료위치에 도달했을 경우
            if(cur.row == dst.row && cur.col == dst.col) {
                // 카운트 반환
                return cur.cnt;
            }
            // 상하좌우 한번씩 이동한 위치를 저장
            for(int i = 0; i < 4; ++i) {
                int nr = cur.row + D[i][0], nc = cur.col + D[i][1];
                //4x4 영역에서 벗어난 값일 경우 제외
                if(nr < 0 || nr > 3 || nc < 0 || nc > 3) continue;
                //이동했음을 기록
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // 이동한 위치를 Queue에 저장
                    queue.add(new Position(nr, nc, cur.cnt + 1));
                }
                //컨트롤키를 입력 계산
                for(int j = 0; j < 2; ++j) {
                    if(Board[nr][nc] != 0) break;
                    if(nr + D[i][0] < 0 || nr + D[i][0] > 3 || nc + D[i][1] < 0 || nc + D[i][1] > 3) break;
                    nr += D[i][0];
                    nc += D[i][1];
                }
                //동일하게 이동했음을 기록
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Position(nr, nc, cur.cnt + 1));
                }
            }
        }
        return INF;
    }

    public int solution(int[][] board, int r, int c) {
        Board = board;
        return permutate(new Position(r,c,0));
    }
}