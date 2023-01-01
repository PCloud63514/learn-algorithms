import java.util.*;

/**
 * ws.amazon.com/ko/free/?trk=ps_a134p000003yHYmAAM&trkCampaign=acq_paid_search_brand&sc_channel=PS&sc_campaign=acquisition_KR&sc_publisher=Google&sc_category=Core-Main&sc_country=KR&sc_geo=APAC&sc_outcome=acq&sc_detail=aws&sc_content=Brand_Core_aws_e&sc_segment=444218215907&sc_medium=ACQ-P|PS-GO|Brand|Desktop|SU|Core-Main|Core|KR|EN|Text&s_kwcid=AL!4422!3!444218215907!e!!g!!aws&ef_id=CjwKCAiA8ov_BRAoEiwAOZogwcFDexAgQK4x686zPt3v44f9efFr9td3xDTk5plukH5E5UW4A-rc3hoCFzMQAvD_BwE:G:s&s_kwcid=AL!4422!3!444218215907!e!!g!!aws&all-free-tier.sort-by=item.additionalFields.SortRank&all-free-tier.sort-order=asc
 */
class Solution {
    // 1 2 3 1
    public static final int BREAD = 1;
    public static final int VEGETABLE = 2;
    public static final int MEAT = 3;

    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            if (4 <= stack.size()) {
                if (stack.get(stack.size() - 4) == BREAD &&
                        stack.get(stack.size() - 3) == VEGETABLE &&
                        stack.get(stack.size() - 2) == MEAT &&
                        stack.get(stack.size() - 1) == BREAD) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }

        return answer;
    }

    public int solution2(int[] ingredient) {
        int answer = 0;

        int[] stack = new int[ingredient.length];
        int cursor = 0;

        for (int i : ingredient) {
            stack[cursor++] = i;
            if (4 > cursor) continue;
            if (stack[cursor - 1] != BREAD) continue;
            if (stack[cursor - 2] != MEAT) continue;
            if (stack[cursor - 3] != VEGETABLE) continue;
            if (stack[cursor - 4] != BREAD) continue;
            cursor = cursor - 4;
            answer = answer + 1;
        }

        return answer;
    }
}