class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int x = 0; x < answer[0].length; x++) {
                int num = 0;
                for (int y = 0; y < arr2.length; y++) {
                    num += arr1[i][y] * arr2[y][x];
                }
                answer[i][x] = num;
            }
        }


        return answer;
    }
}