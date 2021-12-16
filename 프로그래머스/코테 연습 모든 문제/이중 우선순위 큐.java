import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            String symbol = tokens[0];
            int num = Integer.parseInt(tokens[1]);

            if ("D".equals(symbol) && !minQueue.isEmpty()) {
                if (num < 0) {
                    Integer minValue = minQueue.poll();
                    maxQueue.remove(minValue);
                    continue;
                }
                Integer maxValue = maxQueue.poll();
                minQueue.remove(maxValue);
            } else if ("I".equals(symbol)) {
                minQueue.offer(num);
                maxQueue.offer(num);
            }
        }

        if (!minQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        return answer;
    }
}