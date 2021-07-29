class Solution {

    @Test
    public void Test() {
        int[] solution = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        Assertions.assertArrayEquals(solution, new int[]{3,4,2,1,5});
    }
    /**
     * https://www.welcomekakao.com/learn/courses/30/lessons/42889
     * @param N 전체 스테이지 수
     * @param stages 사용자가 현재 멈춰있는 스테이지의 배열
     * @return
     */
    public int[] solution(int N, int[] stages) {
        int[] counts = new int[N + 1];
        Float[] failRates = new Float[N + 1];
        Float[] failRatesIndex = new Float[N + 1];
        int[] answer = new int[N];
        int userCount = stages.length;
        failRates[0] = 200000f; // 가장 큰 값

        for(int stage : stages) {
            if(stage <= N)
                counts[stage]++;
        }

        for (int i = 1; i <=N; ++i) {
            failRates[i] = (float)counts[i] / (float)userCount;
            failRatesIndex[i] = (float)counts[i] / (float)userCount;
            userCount -= counts[i];
        }

        Arrays.sort(failRates, Collections.reverseOrder());

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (failRates[i].compareTo(failRatesIndex[j]) == 0) {
                    answer[i-1] = j;
                    failRatesIndex[j] = -1f;
                    break;
                }
            }

        }
        return answer;
    }
}