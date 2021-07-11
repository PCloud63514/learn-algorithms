class Solution {
    public int solution(String s) {
        String[] numStrs = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        while(isString2Integer(s) == false) {
            for(int i = 0; i < numStrs.length; i++) {
                int index = s.indexOf(numStrs[i]);
                if(-1 < index) {
                    s = s.replace(numStrs[i],Integer.toString(i));
                    break;
                }
            }
        }

        return Integer.parseInt(s);
    }
    
    public boolean isString2Integer(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}