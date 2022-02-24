class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int minValue = 9999999;
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }

        answer = arr.length > 1 ? new int[arr.length-1] : new int[]{-1};
        int answerIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (minIndex != i) {
                answer[answerIndex++] = arr[i];
            }
        }

        return answer;
    }
}