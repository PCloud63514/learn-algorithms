// https://programmers.co.kr/learn/courses/30/lessons/60060?language=java
class Solution {
    static int letter = Character.getNumericValue('a');
    class Node {
        // 문제 조건이 소문자 알파벳이기 떄문에 최대 크기 26을 갖는다.
        Node[] child = new Node[26];
        int cnt = 0;

        void insert(String word) {
            Node node = this;
            for(char ch : word.toCharArray()) {
                node.cnt++;
                // 알파벳의 순서를 index로 만들기 위해 'a' 값을 뺀다.
                int idx = Character.getNumericValue(ch) - letter;
                if(node.child[idx] == null) {
                    node.child[idx] = new Node();
                }

                node = node.child[idx];
            }
            // 마지막 노드 값 증가
            node.cnt++;
        }

        int search(String word) {
            Node node = this;
            for(char ch : word.toCharArray()) {
                if(ch == '?') {
                    return node.cnt;
                }
                node = node.child[Character.getNumericValue(ch) - letter];
                if(node == null) {
                    return 0;
                }
            }
            return node.cnt;
        }
    }
    Node[] nodeRoot = new Node[10000];
    Node[] reverseNodeRoot = new Node[10000];
    @Test
    public void main() {
        String[] words = new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = new String[] {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] result = new int[] {3, 2, 4, 1, 0};
        int[] answer = solution(words, queries);

        Assertions.assertArrayEquals(result, answer);
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int ansIdx = 0;

        for (int i = 0; i < words.length; i++) {
            int idx = words[i].length() - 1;
            if (nodeRoot[idx] == null) {
                nodeRoot[idx] = new Node();
                reverseNodeRoot[idx] = new Node();
            }

            nodeRoot[idx].insert(words[i]);
            reverseNodeRoot[idx].insert(
                    new StringBuilder(words[i]).reverse().toString()
            );
        }

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i].length() - 1;
            if (nodeRoot[idx] == null) {
                answer[ansIdx++] = 0;
                continue;
            }

            if (queries[i].charAt(0) != '?') {
                answer[ansIdx++] = nodeRoot[idx].search(queries[i]);
            } else {
                answer[ansIdx++] = reverseNodeRoot[idx].search(
                        new StringBuilder(queries[i]).reverse().toString()
                );
            }
        }

        return answer;
    }
}