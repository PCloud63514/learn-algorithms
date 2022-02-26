import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        new Program().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

    }

    public int[] solution(int[] array, int[][] commands) {
        int loop = commands.length;
        int[] answer = new int[loop];

        for (int x = 0; x < loop; x++) {
            int i = commands[x][0] - 1;
            int j = commands[x][1];
            int k = commands[x][2] - 1;

            int[] split = Arrays.copyOfRange(array, i, j);
            Arrays.sort(split);
            answer[x] = split[k];
        }

        return answer;
    }
}