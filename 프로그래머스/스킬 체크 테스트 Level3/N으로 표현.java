/**
 * 알고리즘: DP
 * link: https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
 */
class Solution {
    int[] list = new int[100000000];
    public int solution(int N, int number) {
        dfs(N, N, 1, number);
        return list[number] <= 8 ? list[number] : -1;
    }

    void dfs(int N, int X, int count, int number) {
        if (X < 0 || 8 < count) { return; }
        list[X] = count;
        if (0 < list[number]) { return; }

        int Y = N;
        dfs(N, X + Y, count + list[Y], number);
        dfs(N, X - Y, count + list[Y], number);
        dfs(N, X * Y, count + list[Y], number);
        dfs(N, X / Y, count + list[Y], number);

        list[(Y * 10) + N] = list[Y] + 1;
        Y = (Y * 10) + N;
    }
}