import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int x = 10;
        int y = 1;
        int len = (int)Math.log10(n) + 1;

        for (int i = 0; i < len; i++) {
            answer += (n % x) / y;
            x *= 10;
            y *= 10;
        }

        return answer;
    }
}