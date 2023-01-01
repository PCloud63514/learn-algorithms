/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */
class Solution {
    public int solution(String s) {
        int answer = 0;

        char[] chars = s.toCharArray();
        char c = chars[0];
        int x = 0;
        int y = 0;

        for (int i = 0; i < chars.length; i++) {
            if (x == 0) {
                c = chars[i];
                x++;
                continue;
            }
            if (c == chars[i]) {
                x++;
            }
            else {
                y++;
            }
            if (x == y) {
                x = 0;
                y = 0;
                answer++;
            }
        }
        if (x != 0) answer++;
        return answer;
    }
}