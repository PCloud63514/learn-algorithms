import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class Solution {
    public int[][] solution(int n, int m, int[][] rectangle) {
        int[][] board = new int[m][n];
        List<Integer> blockQueue = new ArrayList<>();
        int rectangleCnt = 0;
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i][1]; j++) {
                blockQueue.add(rectangle[i][0]);
            }
            rectangleCnt += rectangle[i][1];
        }
        blockQueue.sort(Comparator.naturalOrder());

        int pX = 0;
        int pY = 0;
        int i = 0;

        while (i < rectangleCnt) {
            Integer block = blockQueue.get(i);
            int useXpoint = isUseX(board, block, n, pY);
            if (useXpoint == -1) {
                if (m < pY + 1) {
                    break;
                }
                pY++;
            } else {
                for (int dY = pY; dY < pY + block; dY++) {
                    for (int dX = useXpoint; dX < useXpoint + block; dX++) {
                        board[dY][dX] = i + 1;
                    }
                }
                i++;
            }
        }

        int[][] answer = new int[i][3];
        boolean[] checkedBlock = new boolean[i];
        int answerIndex = 0;
        for (int _m = 0; _m < m; _m++) {
            for (int _n = 0; _n < n; _n++) {
                int block = board[_m][_n];
                if (block != 0 && !checkedBlock[block - 1]) {
                    answer[answerIndex++] = new int[] { _n, _m, blockQueue.get(block - 1)};
                    checkedBlock[block - 1] = true;
                }
            }
        }

        return answer;
    }

    private int isUseX(int[][] board, int blockSize, int n, int pY) {
        for (int x = 0; x < n - blockSize; x++) {
            boolean usedX = false;
            for (int _x = x; _x < x + blockSize; _x++) {
                if (board[pY][_x] != 0) {
                    usedX = true;
                    break;
                }
            }
            if (!usedX) {
                return x;
            }
        }
        return -1;
    }
}
