import java.util.Arrays;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        int[] aSorted = Arrays.stream(A)
                .sorted()
                .toArray();

        int[] bSorted = Arrays.stream(B)
                .sorted()
                .toArray();

        int endPoint = A.length - 1;

        for (int i = 0; i < A.length; i++) {
            answer += aSorted[i] * bSorted[endPoint - i];
        }

        return answer;
    }
}