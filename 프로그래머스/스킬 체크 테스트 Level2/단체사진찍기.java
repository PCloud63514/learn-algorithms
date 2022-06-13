class Solution {
    int answer = 0;
    String[] friends = new String[] { "A", "C", "F", "J", "M", "N", "R", "T" };
    String[] friendA;
    String[] friendB;
    String[] symbols;
    int[] nums;

    public int solution(int n, String[] data) {
        friendA = new String[n];
        friendB = new String[n];
        symbols = new String[n];
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            String[] split = data[i].split("");
            friendA[i] = split[0];
            friendB[i] = split[2];
            symbols[i] = split[3];
            nums[i] = Integer.parseInt(split[4]);
        }
        dfs(0, new boolean[8], "");
        return answer;
    }

    void dfs(int depth, boolean[] check, String picture) {
        if (8 <= depth) {
            boolean bo = true;
            for (int i = 0; i < friendA.length; i++) {
                if (!bo) break;
                int a = picture.indexOf(friendA[i]);
                int b = picture.indexOf(friendB[i]);
                int abs = Math.abs(a - b);

                switch(symbols[i]) {
                    case "=": if (abs != nums[i] + 1) bo = false;
                        break;
                    case "<": if (!(abs < nums[i] + 1)) bo = false;
                        break;
                    case ">": if (!(abs > nums[i] + 1)) bo = false;
                        break;
                }
            }
            if (bo) answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (check[i]) continue;
            check[i] = true;
            dfs(depth + 1, check, picture + friends[i]);
            check[i] = false;
        }
    }
}