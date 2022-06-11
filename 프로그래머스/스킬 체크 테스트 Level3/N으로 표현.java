/**
 * 알고리즘: DP
 * link: https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
 */
class Solution {
    int answer = 9;
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer <= 8 ? answer : -1;
    }

    void dfs(int N, int number, long X, int count) {
        if (8 < count) return;
        if (X == number && count < answer) { answer = count; }
        int Y = N;
        for (int i = 1; i < 9 - count; i++) {
            dfs(N, number, X + Y, count + i);
            dfs(N, number, X - Y, count + i);
            dfs(N, number, X * Y, count + i);
            dfs(N, number, X / Y, count + i);
            Y = (Y * 10) + N;
        }
    }
}