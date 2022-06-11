import java.util.*;

/**
 * 알고리즘: 투 포인터
 * link:
 */
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[] { 0, gems.length - 1 };
        Set<String> gemSet = new HashSet<>();
        gemSet.addAll(List.of(gems));
        int gemTypeSize = gemSet.size();

        int pl = 0;
        int pr = 0;
        Map<String, Integer> gemCount = new HashMap<>();
        gemCount.put(gems[0], 1);
        while (pl < gems.length && pr < gems.length) {
            if (gemCount.size() != gemTypeSize) {
                pr++;
                if (pr == gems.length) break;
                gemCount.put(gems[pr], gemCount.getOrDefault(gems[pr], 0) + 1);
                continue;
            }
            if (pr - pl < answer[1] - answer[0]) {
                answer[0] = pl;
                answer[1] = pr;
            } else {
                int cNum = gemCount.get(gems[pl]) - 1;
                gemCount.put(gems[pl], cNum);
                if (cNum == 0) {
                    gemCount.remove(gems[pl]);
                }
                pl++;
            }
        }

        answer[0]++;
        answer[1]++;

        return answer;
    }
}