class Solution {
    int cnt = 0; // 설치된 구조물의 갯수
    /**
     *
     * @param n 벽면의 크기
     * @param build_frame 건축 설계도 (행 길이 1~1000 / 열 길이 4) [x, y, a, b] 형태
     *                    x, y - 기둥, 보를 설치 또는 삭제할 교차점의 좌표(가로, 세로)
     *                    a - 설치 또는 삭제할 구조물의 종류. 0 - 기둥 / 1 - 보
     *                    b - 구조물을 설치할 지, 삭제할 지를 나타냄 0 - 삭제 / 1 - 설치
     * @return
     */
    public int[][] solution(int n, int[][] build_frame) {
        int[][] box = new int[n][n]; // 건축물이 설치될 공간. (빈공간 표시를 위해 box에선 기둥 1 보 2이다.
        
        for (int i = 0; i < build_frame.length; ++i) {
            //삭제
            if(build_frame[i][3] == 0) {
                remove(box, build_frame[i][0], build_frame[i][1], build_frame[i][2]);
            } else {
                // 설치
                build(box, build_frame[i][0], build_frame[i][1], build_frame[i][2]);
            }
        }

        int[][] answer = new int[cnt][3];
        for (int i = 0; i < cnt; ++i) {
            for (int row = 0; row < n; ++row) {
                for (int col = 0; col < n; ++col) {
                    if (box[row][col] != 0) {
                        answer[i][0] = row;
                        answer[i][1] = col;
                        answer[i][0] = box[row][col] - 1;
                    }
                }
            }    
        }
        
        return answer;
    }

    // 설치
    // 설치 조건이 맞지 않는 것은 무시된다.
    // 빈 공간 계산하기 불편하니 0을 빈 공간 type의 값을 1씩 늘린다.
    private void build(int[][] box, int row, int col, int type) {
        box[row][col] = type + 1;
        // 흠 굳이 삭제와 설치를 함수로 나누지 않아도 동작은 상당히 비슷할듯
        // 구조물을 설치할 때 설치 위치를 기준으로 결국 상하좌우를 확인하고 가능한 조건을 찾아내는 것이기 때문에
        // 결국 설치 전에 미리 알 수 있을 듯 하다.
        // 그래야 n의 높이보다 높이 설치되는 것을 막을 수도 있을 듯
    }
    // 삭제
    // 삭제 후 삭제 결과의 구조물이 조건에 맞지 않으면 무시된다.
    private void remove(int[][] box, int row, int col, int type) {
        if (box[row][col] == type) {
            box[row][col] = 0;
        }
    }
    // 조건 검사
    private boolean check(int[][] frame) {
        // 바닥은 벽면의 아래를 의미(이거 굳이 의미있나)
        // 기둥은 바닥 위, 보, 기둥 위에 있어야함.(즉 허공 빼고 다됨)
        // 보는 기둥, 양쪽 끝이 동시에 보와 연결(바닥에 안된다.)
        
        return false;
    }
}
