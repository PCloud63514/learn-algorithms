package org.pcloud;

class Solution2 {
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 2; 0 <= i; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }
}

public class Program {
    public static void main(String[] args) {
        new Solution2().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    }
}