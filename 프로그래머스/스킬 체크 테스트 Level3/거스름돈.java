/**
 * 알고리즘: DP
 * link: https://programmers.co.kr/learn/courses/30/lessons/12907
 */
class Solution {
    public int solution(int n, int[] money) {
        int[] answer = new int[n + 1];
        answer[0] = 1;

        for (int num : money) {
            for (int i = num; i <= n; i++) {
                answer[i] += answer[i - num];
            }
        }
        return answer[n] % 1000000007;
    }
}