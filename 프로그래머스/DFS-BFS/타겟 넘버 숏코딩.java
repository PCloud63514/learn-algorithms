class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public static int dfs(int[] numbers, int target, int c, int sum) {
        if (numbers.length == c) {
            if(target == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        return dfs(numbers, target, c + 1, sum + numbers[c]) + dfs(numbers, target, c + 1, sum - numbers[c]);
    }
}