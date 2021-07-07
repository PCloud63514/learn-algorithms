package com.pcloud.jcodetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


@SpringBootTest
class JCodeTestApplicationTests {

    @Test
    public void main() {
//        Assertions.assertEquals(solution("abcxyasdfasdfxyabc"), new String[]{"abc", "xy", "asdf", "asdf", "xy", "abc"});

        String s = "AAACCCCCCCCAAA";
        String temp = "AAA";
        solution2("abcdef");

    }


    public int solution3(String s, String t) {
        int result = 0;

        while(true) {
            int index = s.indexOf(t);
            if(index > -1) {
                s = s.replace(t, "");
                result += 1;
            } else {
                break;
            }
        }

        return result;
    }

    public List<String> getShards2(String s) {
        List<String> strShards = new ArrayList<>();
        String temp = "";
        int index = 0;
        while(index < s.length() - index) {
            temp += s.charAt(index);

            if(temp.equals(s.substring(s.length() - 1 - index)) || (-1 < strShards.indexOf(temp))) {
                strShards.add(temp);
                s = s.substring(temp.length(), s.length() - temp.length());
                temp = "";
                index = 0;
                continue;
            } else {
                index += 1;
            }
        }
        if(temp.equals("") == false) {
            strShards.add(s);
        }
        return strShards;
    }

    public List<String> getShards(String s) {
        List<String> strShards = new ArrayList<>();
        String temp = "";
        int index = 0;
        while(index < s.length() - index) {
            temp += s.charAt(index);
            if(-1 < strShards.indexOf(temp)) {
                s = s.substring(temp.length(), s.length() - temp.length());
                temp = "";
                index = 0;
                continue;
            }
            if(temp.equals(s.substring(s.length() - 1 - index))) {
                strShards.add(temp);
                s = s.substring(temp.length(), s.length() - temp.length());
                temp = "";
                index = 0;
            } else {
                index += 1;
            }
        }
        if(temp.equals("") == false) {
            strShards.add(s);
        }
        return strShards;
    }

    public String[] solution2(String s) {
        List<String> answerList = new ArrayList<>();

        List<String> shards = getShards(s);

        int range = 0;
        while(s.equals("") == false) {
            String sub = s.substring(0, range);
            if(shards.indexOf(sub) != -1) {
                answerList.add(sub);
                s = s.substring(range, s.length());
                range = 0;
            } else {
                range += 1;
            }
        }

        String[] answer = new String[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static int solution1(int[] prices, int[] discounts) {
        int answer = 0;
        List<Integer> priceList = new ArrayList<>();
        List<Integer> discountList = new LinkedList<>();

        for(int i = 0; i < prices.length; i++) {
            priceList.add(prices[i]);
        }

        for(int i = 0; i < discounts.length; i++) {
            discountList.add(discounts[i]);
        }

        priceList.sort(Comparator.reverseOrder());
        discountList.sort(Comparator.reverseOrder());

        for(int i = 0; i < priceList.size(); i++) {
            if(discountList.isEmpty() == false) {
                answer += priceList.get(i) - (priceList.get(i) * discountList.get(0) * 0.01);
                discountList.remove(0);
            } else {
                answer += priceList.get(i);
            }
        }

        return answer;
    }
}