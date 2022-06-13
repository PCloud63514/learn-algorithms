import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        String lowStr1 = str1.toLowerCase();
        String lowStr2 = str2.toLowerCase();

        // str1의 집합 계산
        List<String> combination1 = combination(lowStr1);
        double str1WordCount = combination1.size();
        // str2의 집합 계산
        List<String> combination2 = combination(lowStr2);
        double str2WordCount = combination2.size();

        // 두 집합의 교집합 크기 계산
        double retainSize = 0.0d;
        for (String word : combination2) {
            int i = combination1.indexOf(word);
            if (i != -1) {
                combination1.remove(i);
                retainSize++;
            }
        }


        // 두 집합의 합집합 크기 계산
        double d = retainSize / (str1WordCount + str2WordCount - retainSize);
        d = Double.isNaN(d) ? 1 : d;
        return  (int)(d * 65536);
    }

    List<String> combination(String str) {
        List<String> combinationList = new ArrayList<>();
        String[] list = str.split("");

        for(int i = 0; i < list.length - 1; i++) {
            String word = list[i] + list[i + 1];
            if (word.matches("^[a-z]*$")) {
                combinationList.add(word);
            }
        }
        return combinationList;
    }
}