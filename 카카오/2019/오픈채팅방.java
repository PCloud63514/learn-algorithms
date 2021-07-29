import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    @Test
    public void Test() {
        String[] answer = solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        Assertions.assertArrayEquals(
                new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."},
                answer);
    }

    class Query {
        String command;
        String userId;

        public Query(String command, String userId) {
            this.command = command;
            this.userId = userId;
        }
    }

    int COMMAND = 0;
    int USERID = 1;
    int NICKNAME = 2;
    String C_ENTER = "Enter";
    String C_LEAVE = "Leave";
    String C_CHANGE = "Change";

    public String[] solution(String[] record) {

        Map<String, String> nicknames = new HashMap<String, String>();
        String[] answer = {};
        ArrayList<Query> queries = new ArrayList<>();
        int cnt = 0;

        for (String rcd : record) {
            String[] rcdSplit = rcd.split(" ");

            if (rcdSplit[COMMAND].equals(C_ENTER)) {
                nicknames.put(rcdSplit[USERID], rcdSplit[NICKNAME]);
                queries.add(new Query( rcdSplit[COMMAND], rcdSplit[USERID]));
                cnt++;
            }
            else if (rcdSplit[COMMAND].equals(C_LEAVE)) {
                queries.add(new Query( rcdSplit[COMMAND], rcdSplit[USERID]));
                cnt++;
            }
            else if (rcdSplit[COMMAND].equals(C_CHANGE)) {
                nicknames.put(rcdSplit[USERID], rcdSplit[NICKNAME]);
            }
        }

        answer = new String[cnt];
        cnt = 0;
        for (Query query : queries) {
            if (query.command.equals(C_ENTER)) {
                answer[cnt++] = String.format("%s님이 들어왔습니다.", nicknames.get(query.userId));
            } else {
                answer[cnt++] = String.format("%s님이 나갔습니다.", nicknames.get(query.userId));
            }
        }
        return answer;
    }
}