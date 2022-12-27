/**
 * title: Number of Steps to Reduce a Number to Zero
 * link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 */

class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        int value = num;

        while (value != 0) {
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value--;
            }
            step++;
        }
        return step;
    }
}