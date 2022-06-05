class Solution {
    public String solution(String s) {
        int min = 99999999;
        int max = -9999999;
        String answer = "";

        String[] split = s.split(" ");

        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return "" + min + " " + max;
    }
}