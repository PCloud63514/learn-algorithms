import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int[][] test2 = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};

        solution.solution(test1, 1, 0);
        solution.solution(test2, 0, 1);
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
        for(int num = 1; num <=6; num++) {
            List<Position> card = new ArrayList<>();
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(Board[i][j] == num) {
                        card.add(new Position(i, j, 0));
                    }
                }
            }
            if(card.isEmpty()) continue;
            int one = bfs(position, card.get(0)) + bfs(card.get(0), card.get(1)) + 2;
            int two = bfs(position, card.get(1)) + bfs(card.get(1), card.get(0)) + 2;
            for(int i = 0; i < 2; i++) {
                Board[card.get(i).row][card.get(i).col] = 0;
            }
            ret = Math.min(ret, one + permutate(card.get(1)));
            ret = Math.min(ret, two + permutate(card.get(0)));

            for(int i = 0; i < 2; i++) {
                Board[card.get(i).row][card.get(i).col] = num;
            }
        }
        if(ret == INF) {
            return 0;
        }
        return ret;
    }

    private int bfs(Position src, Position dst) {
        boolean[][] visited = new boolean[4][4];
        Queue<Position> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()) {
            Position cur = queue.poll();
            if(cur.row == dst.row && cur.col == dst.col) {
                return cur.cnt;
            }
            for(int i = 0; i < 4; i++) {

            }
        }
        return INF;
    }

    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        return answer;
    }
}