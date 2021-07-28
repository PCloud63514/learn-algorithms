import java.util.*;

class Solution {
    int pos = 0;
    boolean isCorrect(String s) {
        boolean b = true;
        int left = 0, right = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                left++;
                stack.push('(');
            } else {
                right++;
                if(stack.empty()) {
                    b = false;
                } else {
                    stack.pop();
                }
            }
            if(left == right) {
                pos = i + 1;
                return b;
            }
        }
        return b;
    }

    /**
     * 2020 카카오 코드테스트 괄호 변환 문제
     * 링크 https://programmers.co.kr/learn/courses/30/lessons/60058
     *
     * @param p
     * @return
     */
    public String solution(String p) {
        String answer = "";
        if(p.isEmpty()) return p;

        boolean correct = isCorrect(p);

        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());

        if(correct) {
            return u + solution(v);
        }

        answer = "(" + solution(v) + ")";

        for(int i = 1; i < u.length() - 1; ++i) {
            if(u.charAt(i) == '(') {
                answer += ")";
            } else {
                answer += "(";
            }
        }

        return answer;
    }
}