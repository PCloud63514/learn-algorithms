import java.util.*;
import java.util.stream.Collectors;
class Solution {
    static Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    public int solution(int[] numbers, int target) {
        dfs(numbers, new int[0], 0);
        return counts.getOrDefault(target, 0);
    }
    
    public static void dfs(int[] ori, int[] numbers, int c) {
        // ori랑 numbers 크기가 같아지면 값을 다 꺼내서 합 연산
        // Map에 합연산 결과를 key로, value 를 count로 지정하여 count를 증가
        // 리턴
        if(ori.length == numbers.length) {
            int value = Arrays.stream(numbers).sum();
            int count = counts.getOrDefault(value, -1);
            if (count == -1) {
                counts.put(value, 1);
            } else {
                counts.put(value, count + 1);
            }
            return;
        }
        List<Integer> collect = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        collect.add(ori[c]);
        dfs(ori, collect.stream().mapToInt(i->i).toArray(), c + 1);
        collect.set(collect.size() -1, collect.get(collect.size() - 1) * -1);
        dfs(ori, collect.stream().mapToInt(i->i).toArray(), c + 1);
    }
}