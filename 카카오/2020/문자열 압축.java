class Solution {
    /**
     * 2020 카카오 코드테스트 문자열 압축 문제
     * 링크 https://programmers.co.kr/learn/courses/30/lessons/60057
     *
     * 기존에도 풀었었는데 ezsw 유튜버님의 영상을 보고 다시 풀어보았다.
     * 이전엔 직접 압축 후 길이를 계산하는 방식으로 진행했는데, StringBuilder를 사용하는 것이 아닌
     * 오직 길이만 계산하는 효율적인 방법이 배울 것이라 생각해 다시 풀었다.
     * @param s
     * @return
     */
    public int solution(String s) {
        int answer = s.length();

        // i = 압축할 문자열의 길이.
        for ( int i = 1; i <= s.length() / 2; ++i) {
            int pos = 0;
            int len = s.length();

            while (pos + i <= s.length()) {
                // 현재 위치(pos) 부터 i 만큼 문자열을 가져온다. (압축할 대상)
                String unit = s.substring(pos, pos + i);
                pos += i;

                int cnt = 0;
                while (pos + i <= s.length()) {
                    // pos 변경 후에도 같은 문자열이므로 압축 대상
                    if(unit.equals(s.substring(pos, pos + i))) {
                        ++cnt;
                        pos += i;
                    } else {
                        break;
                    }
                }

                if( cnt > 0) {
                    // 압축 cnt * i 만큼 길이를 감소 (압축됨)
                    len -= i * cnt;
                    
                    // 압축 cnt에 따라 길이를 추가 (압축 후 숫자를 길이에 추가)
                    if(cnt < 9) len += 1;
                    else if(cnt < 99) len += 2;
                    else if(cnt < 999) len += 3;
                    else len += 4;
                }
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }
}