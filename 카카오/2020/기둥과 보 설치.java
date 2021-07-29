package com.pcloud.simplespringsecurity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

@SpringBootTest
class Solution {
    int cnt = 0; // 설치된 구조물의 갯수
    int X = 0;
    int Y = 1;
    int TYPE = 2;
    int COMMAND = 3;
    int TYPE_PILLAR = 0;
    int TYPE_BOARD = 1;
    int COMMAND_REMOVE = 0;
    int COMMAND_BUILD = 1;
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
    @Test
    public int[][] solution(int n, int[][] build_frame) {
        int[][] box = new int[n][n]; // 건축물이 설치될 공간. (빈공간 표시를 위해 box에선 기둥 1 보 2이다.

        for (int i = 0; i < build_frame.length; ++i) {
            if (build_frame[i][COMMAND] == COMMAND_BUILD) {
                build(box, build_frame[i][X], build_frame[i][Y], build_frame[i][TYPE]);
            } else {

            }
        }

        int[][] answer = new int[cnt][3];
        for (int i = 0; i < cnt; ++i) {
            for (int row = 0; row < n; ++row) {
                for (int col = 0; col < n; ++col) {
                    // box 값이 0이 아닌 값은 건축물
                    if (box[row][col] != 0) {
                        answer[i][X] = row;
                        answer[i][Y] = col;
                        answer[i][TYPE] = box[row][col] - 1;
                    }
                }
            }
        }

        return answer;
    }

    /**
     * 기둥 설치 기준
     *  - x이 0 일 경우
     *  - x가 1 이상이며, x - 1에 구조물이 설치되었을 때 (값이 0이 아닐 때)
     * 보 설치 기준
     *  - x가 1이상이며, 아래 기둥이 설치되었을 때
     *  - x가 1이상이며, 양 옆에 보가 설치되어 있을 때
     *
     * @param box
     * @param x
     * @param y
     * @param type
     */
    private void build(int[][] box, int x, int y, int type) {
        // 기둥 일 때
        if (type == TYPE_PILLAR) {
            // 설치할 x가 0일 때 - 바닥
            if (x == 0) {
                box[X][Y] = TYPE_PILLAR + 1;
                cnt++;
            } else {
                // 자신 아래에 기둥 or 보가 있을 때
                if (box[X][Y - 1] != 0) {
                    box[X][Y] = TYPE_PILLAR;
                    cnt++;
                }
            }
        } else {
            if (1 <= x) {
                // 아래가 기둥일 때 
                if (box[x][y - 1] == TYPE_PILLAR + 1) {
                    box[x][y] = TYPE_BOARD + 1;
                    cnt++;
                    return;
                }
                // 양 옆에 보가 설치되었을 때
                if(0 < y && y < box.length) {
                    if (box[x][y - 1] == TYPE_BOARD + 1 && box[x][y + 1] == TYPE_BOARD + 1) {
                        box[x][y] = TYPE_BOARD + 1;
                        cnt++;
                    }
                }
                
            }
        }
    }
}
// 그냥 throw 처리 해서 제외시켜야할듯?