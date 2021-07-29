class Solution {
    int X = 0;
    int Y = 1;
    int TYPE = 2;
    int COMMAND = 3;
    int TYPE_PILLAR = 0;
    int TYPE_PLATE = 1;
    int COMMAND_REMOVE = 0;
    int COMMAND_BUILD = 1;

    boolean[][] box_pillar;
    boolean[][] box_plate;
    /**
     *
     * @param n 벽면의 크기
     * @param build_frame 건축 설계도 (행 길이 1~1000 / 열 길이 4) [x, y, a, b] 형태
     *                    x, y - 기둥, 보를 설치 또는 삭제할 교차점의 좌표(가로, 세로)
     *                    a - 설치 또는 삭제할 구조물의 종류. 0 - 기둥 / 1 - 보
     *                    b - 구조물을 설치할 지, 삭제할 지를 나타냄 0 - 삭제 / 1 - 설치
     *
     *                    핵심 조건
     *                    벽면을 벗어나게 기둥, 보를 설치하는 경우는 없습니다.
     *                    바닥에 보를 설치 하는 경우는 없습니다.
     * @return
     */
    public int[][] solution(int n, int[][] build_frame) {
        box_pillar = new boolean[n + 2][n + 2]; // out of range를 피하기 위해 패딩을 줌
        box_plate = new boolean[n + 2][n + 2];  // out of range를 피하기 위해 패딩을 줌
        int cnt = 0; // 설치된 구조물의 갯수

        for (int[] build : build_frame) {
            if (build[TYPE] == TYPE_PILLAR) {
                if (build[COMMAND] == 1) {
                    if (checkPillar(build[X], build[Y])) {
                        box_pillar[build[X]][build[Y]] = true;
                        cnt++;
                    }
                } else {
                    // 삭제
                    box_pillar[build[X]][build[Y]] = false;
                    if (canDelete(build[X], build[Y]) == false) {
                        box_pillar[build[X]][build[Y]] = true;
                    } else {
                        cnt--;
                    }
                }
            } else {
                if (build[COMMAND] == 1) {
                    if (checkPlate(build[X], build[Y])) {
                        box_plate[build[X]][build[Y]] = true;
                        cnt++;
                    }
                } else {
                    box_plate[build[X]][build[Y]] = false;
                    if (canDelete(build[X], build[Y]) == false) {
                        box_plate[build[X]][build[Y]] = true;
                    } else {
                        cnt--;
                    }
                }
            }
        }
        int[][] answer = new int[cnt][3];
        cnt = 0;
        for (int x = 0; x <= n; ++x) {
            for (int y = 0; y <= n; ++y) {
                if (box_pillar[x][y]) {
                    answer[cnt][X] = x;
                    answer[cnt][Y] = y;
                    answer[cnt++][TYPE] = TYPE_PILLAR;
                }

                if (box_plate[x][y]) {
                    answer[cnt][X] = x;
                    answer[cnt][Y] = y;
                    answer[cnt++][TYPE] = TYPE_PLATE;
                }
            }
        }
        return answer;
    }

    private boolean canDelete(int x, int y) {
        for (int i = Math.max(x-1, 0); i <= x+1; ++i) {
            for (int j = y; j <= y+1; ++j) {
                if (box_pillar[i][j] && checkPillar(i , j) == false) {
                    return false;
                }
                if (box_plate[i][j] && checkPlate(i, j) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkPlate(int x, int y) {
        // 판 오른쪽에도 설치가 가능
        if (box_pillar[x][y-1] || box_pillar[x+1][y-1]) {
            return true;
        }
        if (0 < x && box_plate[x-1][y] && box_plate[x+1][y]) {
            return true;
        }
        return false;
    }

    private boolean checkPillar(int x, int y) {
        if (y == 0 || box_pillar[x][y - 1]) {
            return true;
        }
        if ((0 < x && box_plate[x-1][y]) || box_plate[x][y]) {
            return true;
        }
        return false;
    }
}