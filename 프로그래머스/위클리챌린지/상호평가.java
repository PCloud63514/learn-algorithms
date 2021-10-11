class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        int studentNum = scores.length;
        
        for (int self = 0; self < studentNum; ++self) {
            int selfScore = scores[self][self];
            int minValue = 101;
            int maxValue = 0;
            float sumScore = 0f;
            
            for (int evaluator = 0; evaluator < studentNum; ++evaluator) {
                int currentScore = scores[evaluator][self];
                if (self != evaluator) {
                    if (maxValue < currentScore) {
                        maxValue = currentScore;
                    } else if (currentScore < minValue) {
                        minValue = currentScore;
                    }
                    sumScore += currentScore;
                }
            }
                        
            float scoreAverage = 0f;
            
            if (selfScore < minValue || maxValue < selfScore) {
                scoreAverage = sumScore / (studentNum - 1);
            } else {
                scoreAverage = (selfScore + sumScore) / studentNum;
            }

            System.out.println(scoreAverage);
            
            if (90 <= scoreAverage) {
                answer += "A";
            } else if (80 <= scoreAverage) {
                answer += "B";
            } else if (70 <= scoreAverage) {
                answer += "C";
            } else if (50 <= scoreAverage) {
                answer += "D";
            } else {
                answer += "F";
            }
        }

        return answer;
    }
}