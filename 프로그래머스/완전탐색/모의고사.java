public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        program.solution(new int[]{1,2,3,4,5});
    }

    public int[] solution(int[] answers) {
        int[] result = {};
        int[] aPattern = new int[] { 1, 2, 3, 4, 5 };
        int[] bPattern = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] cPattern = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            int aAnswer = aPattern[i % aPattern.length];
            int bAnswer = bPattern[i % bPattern.length];
            int cAnswer = cPattern[i % cPattern.length];

            if (aAnswer == answer) { aCnt++; }
            if (bAnswer == answer) { bCnt++; }
            if (cAnswer == answer) { cCnt++; }
        }

        int bestScore = Math.max(Math.max(aCnt, bCnt), cCnt);

        int size = 0;
        int index = 0;

        if (aCnt == bestScore) { size++; }
        if (bCnt == bestScore) { size++; }
        if (cCnt == bestScore) { size++; }

        result = new int[size];

        if (aCnt == bestScore) {
            result[index++] = 1;
        }

        if (bCnt == bestScore) {
            result[index++] = 2;
        }

        if (cCnt == bestScore) {
            result[index++] = 3;
        }

        return result;
    }
}
