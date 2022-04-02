import java.util.PriorityQueue;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        for (int number : numbers) {
            queue.remove(number);
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            answer += poll;
        }

        return answer;
    }
}