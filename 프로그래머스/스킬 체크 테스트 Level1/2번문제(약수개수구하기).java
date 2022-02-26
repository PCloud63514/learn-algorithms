public class Program {
    public static void main(String[] args) {
        new Program().solution(13, 17);

    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int cnt = 1;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) cnt++;
            }
            answer = (cnt % 2 == 0) ? answer + i : answer - i;
        }

        return answer;
    }
}