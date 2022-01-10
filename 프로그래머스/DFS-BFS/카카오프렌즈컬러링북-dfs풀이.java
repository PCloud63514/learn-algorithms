public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        program.solution(6, 4,
                new int[][]{{1, 1, 1, 0},
                        {1, 2, 2, 0},
                        {1, 0, 0, 1},
                        {0, 0, 0, 1},
                        {0, 0, 0, 3},
                        {0, 0, 0, 3}});
    }

    static int numberOfArea = 0; // 그룹핑 된 영역
    static int maxSizeOfOneArea = 0; // 가장 큰 크룹핑 된 영역
    static int currentSizeOfOneArea = 0; // 현재 탐색 중인 그룹의 영역
    static boolean[][] pictureCheck;
    static int[][] joyStick = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int X = 0;
    static final int Y = 1;

    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        pictureCheck = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = picture[i][j];
                if (color != 0 && !pictureCheck[i][j]) {
                    numberOfArea++;
                    dfs(picture, m, n, i, j);
                    if (maxSizeOfOneArea < currentSizeOfOneArea) { maxSizeOfOneArea = currentSizeOfOneArea; }
                    currentSizeOfOneArea = 0;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    /**
     * @param picture 어피치 사진
     * @param m 어피치 사진 가로 크기
     * @param n 어피치 사진 세로 크기
     * @param x 탐색 중인 가로 위치
     * @param y 탐색 중인 세로 위치
     */
    public void dfs(int[][] picture, int m, int n, int x, int y) {
        pictureCheck[x][y] = true;
        currentSizeOfOneArea++;
        // 상하좌우 이동할 수 있는 방향으로 dfs 시도
        for (int c = 0; c < 4; c++) {
            int nextX = x + joyStick[c][X];
            int nextY = y + joyStick[c][Y];

            if (nextX < 0 || m <= nextX || nextY < 0 || n <= nextY) continue;
            if (!pictureCheck[nextX][nextY] && picture[x][y] == picture[nextX][nextY]) {
                dfs(picture, m, n, nextX, nextY);
            }
        }
    }
}
