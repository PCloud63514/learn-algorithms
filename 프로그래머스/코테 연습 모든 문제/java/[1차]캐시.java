import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        for (String city : cities) {
            city = city.toUpperCase();
            if (queue.remove(city)) {
                answer += 1;
                queue.offer(city);
            } else {
                answer += 5;
                if (cacheSize <= queue.size()) {
                    queue.offer(city);
                    queue.poll();
                } else {
                    queue.offer(city);
                }
            }
        }

        return answer;
    }
}