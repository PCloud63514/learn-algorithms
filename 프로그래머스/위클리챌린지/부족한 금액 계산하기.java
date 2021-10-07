class Solution {
    public long solution(int price, int money, int count) {
        long sumNum = 0L;
        for (int i = 1; i <= count; ++i) {
            sumNum += price * i;
        }
        
        if (sumNum <= money) {
            return 0;
        }
        
        return sumNum - money;
    }
}