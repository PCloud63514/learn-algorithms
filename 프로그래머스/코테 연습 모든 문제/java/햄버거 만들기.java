import java.util.*;
class Solution {
    // 1 2 3 1
    public static final int BREAD = 1;
    public static final int VEGETABLE = 2;
    public static final int MEAT = 3;

    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            if (4 <= stack.size()) {
                if (stack.get(stack.size() - 4) == BREAD &&
                        stack.get(stack.size() - 3) == VEGETABLE &&
                        stack.get(stack.size() - 2) == MEAT &&
                        stack.get(stack.size() - 1) == BREAD) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }

        return answer;
    }
}