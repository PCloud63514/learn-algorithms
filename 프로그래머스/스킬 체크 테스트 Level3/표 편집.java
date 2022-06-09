import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleteIdStack = new Stack<>();
        for (int i = 0; i < cmd.length; i++) {
            String[] split = cmd[i].split(" ");
            switch(split[0]) {
                case "U": k -= Integer.parseInt(split[1]);
                    break;
                case "D": k += Integer.parseInt(split[1]);
                    break;
                case "C":
                    deleteIdStack.push(k);
                    if (k == --n) k--;
                    break;
                case "Z":
                    n++;
                    if (deleteIdStack.pop() <= k) k++;
                    break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("O");
        }
        while (!deleteIdStack.isEmpty()) {
            builder.insert(deleteIdStack.pop(), "X");
        }
        return builder.toString();
    }
}