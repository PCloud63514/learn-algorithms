class Solution {
    int index = 0;
    int[][] answer;
    public int[][] solution(int n) {
        int num = ((int)Math.pow(2, n)) - 1;
        answer = new int[num][2];

        hanoi(1, 3, 2, n);

        return answer;
    }

    void hanoi(int s, int end, int route, int plat) {
        if (plat == 0) return;
        hanoi(s, route, end, plat - 1);
        answer[index++] = new int[] { s, end };
        hanoi(route, end, s, plat - 1);
    }
}