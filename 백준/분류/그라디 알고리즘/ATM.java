import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = scanner.nextInt();
        }

        int answer = 0;
        int delay = 0;
        for (int i = 0; i < n; ++i) {
            int minIndex = 0;
            for (int j = 0; j < n; ++j) {
                if (delay + p[j] < delay + p[minIndex]) {
                    minIndex = j;
                }
            }
            delay += p[minIndex];
            answer += delay;

            p[minIndex] = 99999;
        }

        System.out.println(answer);
    }
}