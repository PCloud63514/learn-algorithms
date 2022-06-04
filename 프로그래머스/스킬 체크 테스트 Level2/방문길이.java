class Solution {
    public int solution(String dirs) {
        boolean[][][][] record = new boolean[11][11][11][11];
        int answer = 0;
        String[] play = dirs.split("");
        int curr_x = 5;
        int curr_y = 5;
        int next_x = 5;
        int next_y = 5;

        for (int i = 0; i < play.length; i++) {
            switch(play[i]) {
                case "U": if (curr_y < 10) next_y++; break;
                case "D": if (curr_y > 0) next_y--; break;
                case "R": if (curr_x < 10) next_x++; break;
                case "L": if (curr_x > 0) next_x--; break;
            }
            System.out.println(curr_y != next_y || curr_x != next_x);
            if((curr_y != next_y || curr_x != next_x) &&
                    !record[curr_x][curr_y][next_x][next_y]) {
                record[curr_x][curr_y][next_x][next_y] = true;
                record[next_x][next_y][curr_x][curr_y] = true;
                answer++;
            }
            curr_x = next_x;
            curr_y = next_y;
        }

        return answer;
    }
}