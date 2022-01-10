import java.util.PriorityQueue;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Token> queue = new PriorityQueue<Token>((Token t1, Token t2) -> t1.token < t2.token ? 1 : -1);

        for (int number : numbers) {
            queue.offer(new Token(number));
        }

        while (!queue.isEmpty()) {
            Token poll = queue.poll();
            answer.append(poll.number);
        }

        if (answer.substring(0, 1).equals("0")) return "0";
        return answer.toString();
    }
}

class Token {
    static float _MAX_TOKEN_LENGTH = 4.0f;
    int number;
    int token;

    public Token(int number) {
        this.number = number;
        String numStr = String.valueOf(number);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.ceil(_MAX_TOKEN_LENGTH / numStr.length()); i++) {
            int l = (int)_MAX_TOKEN_LENGTH - sb.length();
            l = Math.min(numStr.length(), l);
            sb.append(numStr.substring(0, l));
        }
        
        token = Integer.parseInt(sb.toString());
    }
}