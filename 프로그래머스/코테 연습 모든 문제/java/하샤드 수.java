class Solution {
    public boolean solution(int x) {
        int value = 0;
        char[] chars = String.valueOf(x).toCharArray();

        for (char c : chars) {
            value += Character.getNumericValue(c);
        }

        if (x % value == 0) {
            return true;
        }
        return false;
    }
}