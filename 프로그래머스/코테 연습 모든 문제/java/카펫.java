class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int num = brown + yellow;

        for (int i = 3; i <= num; i++) {
            if (num % i == 0) {
                int h = (int)num / i;
                if ((i - 2) * (h - 2) == yellow) {
                    int w = Math.max(h, i);
                    h = Math.min(h, i);
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }

        return answer;
    }
}