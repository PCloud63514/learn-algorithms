class Solution {
    public int[] solution(int[] p) {
        int[] answer = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            int minValue = 1001;
            int minIndex = 0;
            // 배열 순회를 통해 가장 작은 값을 찾는다. p[j]
            for (int j = i; j < p.length; j++) {
                if (p[j] < minValue) {
                    minValue = p[j];
                    minIndex = j;
                }
            }

            // p[i]와 결과가 다를 경우 서로 위치를 변경한다.
            if (p[i] != p[minIndex]) {
                System.out.println(p[i] + "|" + p[minIndex]);
                p[minIndex] = p[i];
                p[i] = minValue;
                answer[minIndex]++;
                answer[i]++;
            }
        }

        return answer;
    }
}