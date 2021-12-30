import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public String solution(int[] stones, int k) {
        String answer = "-1";
        Queue<Node> nodes = new LinkedList<>();
        List<Node> answerList = new ArrayList<>();

        nodes.add(new Node("", stones));

        while (!nodes.isEmpty()) {
            // 노드에서 꺼낸다.
            Node poll = nodes.poll();
            // 돌탑 수 만큼 for문을 돈다
            int count = 0;
            for (int i = 0; i < poll.stones.length; i++) {
                boolean isFail = false;
                int[] pollStonesClone = poll.stones.clone();
                for (int y = 0; y < stones.length; y++) {
                    // 포문 인덱스의 돌을 하나 추가한다.
                    if (i == y || isFail) {
                        pollStonesClone[y] += 1;
                        count += pollStonesClone[y];
                        continue;
                    };
                    // 나머지 돌무더기에 돌을 뺀다.
                    pollStonesClone[y] -= 1;
                    // 단 뺄 때 0 미만이 되는 돌무더기가 있으면 실패로 처리한다.
                    if (pollStonesClone[y] <= -1) {
                        isFail = true;
                        break;
                    }
                    count += pollStonesClone[y];
                }
                if (!isFail && k <= count) {
                    // node의 index에 인덱스 값을 추가한다.
                    String index = poll.index + i;
                    // 노드에 넣는다.
                    // 정답 조건을 체크한다.
                    int kCount = 0;
                    boolean f = false;
                    for (int stone : pollStonesClone) {
                        if (stone != 0) {
                            if (stone == k) {
                                kCount += 1;
                            } else {
                                f = true;
                                break;
                            }
                        }
                    }
                    if (!f && kCount == 1) {
                        answerList.add(new Node(index, pollStonesClone));
                    } else {
                        nodes.add(new Node(index, pollStonesClone));
                    }
                }
            }
        }
        if (!answerList.isEmpty()) {
            answer = answerList.get(answerList.size() - 1).index;
        }
        return answer;
    }
}

class Node {
    String index;
    int[] stones;

    Node(String index, int[] stones) {
        this.index = index;
        this.stones = stones;
    }
}