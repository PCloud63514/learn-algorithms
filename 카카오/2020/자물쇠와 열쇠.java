import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Solution {

    /**
     * 2020 카카오 코드테스트 자물쇠와 열쇠 문제
     * 링크 https://programmers.co.kr/learn/courses/30/lessons/60059
     * @param key
     * @param lock
     * @return
     */
    public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;
        // key의 크기와
        for (int r = 0; r < offset + lock.length; ++r) {
            for (int c = 0; c < offset + lock.length; ++c) {
                //4방향 회전
                for (int rot = 0; rot < 4; ++rot) {
                    // 최대 key, lock 둘 다 20 x 20 크기를 가정하여, 패딩영역을 계산했을 때 크기 60 x 60이 나오며,
                    // key와 lock이 하나라도 겹친 상태를 위해 상하좌우 영역을 1씩 빼므로 58 x 58
                    int[][] arr = new int[58][58];
                    for (int i = 0; i < lock.length; ++i) {
                        for(int j = 0; j < lock.length; ++j) {
                            // 패딩이 적용된 lock 배열을 만든다.
                            //
                            arr[offset + i][offset + j] = lock[i][j];
                        }
                    }
                    match(arr, key, rot, r, c);
                    if(check(arr, offset, lock.length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //전부 1인지 검사.
    private boolean check(int[][] arr, int offset, int n) {
        for ( int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (arr[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param arr 적용할 배열
     * @param key
     * @param rot 0 - 0도 / 1 - 90도 / 2 - 180도 / 3 - 270도
     * @param r row 위치
     * @param c col 위치
     */
    private void match(int[][] arr, int[][] key, int rot, int r, int c) {
        int n = key.length - 1;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if(rot == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if (rot == 1) {//90도
                    arr[r + i][c + j] += key[j][n - i];
                } else if (rot == 2) { // 180도
                    arr[r + i][c + j] += key[n - i][n - j];
                } else {
                    arr[r + i][c + j] += key[n - j][i];
                }
            }
        }
    }
}
