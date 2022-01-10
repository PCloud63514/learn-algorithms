class Solution {
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) {
                answer = 999;
                dfs(words, begin, target, 0);
                break;
            }
        }
        
        return answer;
    }
    
    public void dfs(String[] words, String begin, String target, int count) {
        if (count > answer) {
            return;
        }
        if (begin.equals(target)) {
            answer = answer > count ? count : answer;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            int er = 0;
            for(int j = 0; j < words[i].length(); j++) {
                if(words[i].charAt(j) != begin.charAt(j)) {
                    er += 1;
                }
            }
            if(er == 1) {
                String temp = words[i];
                words[i] = "";
                dfs(words, temp, target, count + 1);
                words[i] = temp;
            }
        }
    }
}