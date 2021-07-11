import java.util.ArrayList;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean[] compose = new boolean[nums.length];

        dfs(nums, compose, numbers, 0, 3);

        for(int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            boolean check = false;
            for(int j = 2; j <= num/2; j++) {
                if(num % j == 0) {
                    check = true;
                    break;
                }
            }
            if(check == false) {
                answer += 1;
            }
        }
        return answer;
    }
    
    public void dfs(int[] nums, boolean[] compose, ArrayList<Integer> numbers, int s, int c) {
        if(c == 0) {
            int num = 0;
            for(int i = 0; i < nums.length; i++) {
                if(compose[i]) {
                    num += nums[i];
                }
            }
            numbers.add(num);
            return;
        }

        for(int i = s; i < nums.length; i++) {
            if(compose[i] == false) {
                compose[i] = true;
                dfs(nums, compose, numbers, i + 1, c - 1);
                compose[i] = false;
            }
        }
    }
}