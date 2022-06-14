/**
 * 알고리즘: DP
 * link: https://programmers.co.kr/learn/courses/30/lessons/42897?language=java
 */
class Solution {
    public int solution(int[] money) {
        int[] arr1 = new int[money.length];
        int[] arr2 = new int[money.length];

        for (int i = 0; i < money.length - 1; i++) {
            arr1[i + 1] = money[i];
            arr2[i + 1] = money[i + 1];
        }

        steal(arr1);
        steal(arr2);
        return Math.max(arr1[arr1.length - 1], arr2[arr2.length - 1]);
    }

    void steal(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i + 1] = Math.max(arr[i], arr[i - 1] + arr[i + 1]);
        }
    }
}

public class Program {
    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{1, 2, 3, 1});

        System.out.println(solution);
    }
}