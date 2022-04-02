import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int dump = arr[0];
        list.add(dump);
        
        for (int i = 1; i < arr.length; ++i) {
            if (dump != arr[i]) {
                dump = arr[i];
                list.add(arr[i]);
            }
        }
        answer = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            answer[i++] = num;
        }
        
        return answer;
    }
}