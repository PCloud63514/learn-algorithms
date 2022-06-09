import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
 */
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        final int userCnt = id_list.length;
        int[] answer = new int[userCnt];

        HashMap<String, Integer> userIdByNameMap = new HashMap<>();
        HashMap<String, Set<Integer>> reportMap = new HashMap<>();

        for (int i = 0 ; i < userCnt; i++) {
            String userName = id_list[i];
            userIdByNameMap.put(userName, i);
            reportMap.put(userName, new HashSet<Integer>());
        }

        for (String reportContent : report) {
            String[] content = reportContent.split(" ");
            String reportParson = content[0];
            String reportTarget = content[1];

            reportMap.get(reportTarget).add(userIdByNameMap.get(reportParson));
        }

        for (String reportTarget : id_list) {
            if (k <= reportMap.get(reportTarget).size()) {
                reportMap.get(reportTarget).forEach(reportParsonId -> answer[reportParsonId]++);
            }
        }

        return answer;
    }
}