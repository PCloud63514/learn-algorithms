class Solution {
    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];

        for (int i = 0; i < periods.length; i++) {
            int period = periods[i]; // 고객의 가입 기간
            int payment = 0;         // 고객의 최근 12개월 납부 금액
            int nextPayment = 0;     // 고객의 다음달 12개월 납부 금액
            for (int j = 0; j < 12; j++) {
                payment += payments[i][j];
            }
            nextPayment = payment - payments[i][0] + estimates[i];
            System.out.println("[" + i + "] " +  period + "|" + payment + "|" + nextPayment);
            if (60 <= period) {
                if (payment < 600000 && 600000 <= nextPayment) {
                    answer[0]++;
                    continue;
                }
                if (600000 <= payment && nextPayment < 600000) {
                    answer[1]++;
                    continue;
                }
            } else if (23 <= period) {
                if (payment < 900000 && 900000 <= nextPayment) {
                    answer[0]++;
                    continue;
                }
                if (24 == period + 1  && 900000 <= nextPayment) {
                    answer[0]++;
                    continue;
                }
                if (60 == period + 1 && 600000 <= nextPayment) {
                    answer[0]++;
                    continue;
                }
                if (period + 1 < 60 && 900000 <= payment && nextPayment < 900000) {
                    answer[1]++;
                    continue;
                }
                if (60 <= period + 1 && 600000 <= payment && nextPayment < 600000) {
                    answer[1]++;
                    continue;
                }
            }
        }

        return answer;
    }
}