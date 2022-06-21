/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057?language=java
 *
 */
class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; ++i) {
            int pos = 0;
            // 문자열을 실제로 압축 후 길이를 구하는 방법이 아닌
            // 미리 문자열의 총 길이를 계산 후 차감하는 방식으로 계산한다.
            int len = s.length();

            while (pos + i <= s.length()) {
                // 현재 위치(pos) 부터 i 만큼 문자열을 가져온다. (압축할 대상)
                String unit = s.substring(pos, pos + i);
                pos += i;

                int cnt = 0;
                while (pos + i <= s.length()) {
                    // pos 변경 후에도 같은 문자열이므로 압축 대상
                    if (unit.equals(s.substring(pos, pos + i))) {
                        ++cnt;
                        pos += i;
                    } else {
                        break;
                    }
                }

                if (cnt > 0) {
                    len -= i * cnt;

                    if (cnt < 9) len += 1;
                    else if (cnt < 99) len += 2;
                    else if (cnt < 999) len += 3;
                    else len += 4;
                }
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }
}