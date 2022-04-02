class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] field = new char[place.length][];

            for (int j = 0; j < field.length; j++) {
                field[j] = place[j].toCharArray();
            }
            boolean isFailure = false;
            for (int x = 0; x < field.length; x++) {
                if (isFailure) { break; }
                for (int y = 0; y < field[x].length; y++) {
                    int score = 0;

                    if (field[x][y] == 'P') {
                        score = 0;
                    } else if (field[x][y] == 'O') {
                        score = -1;
                    } else {
                        continue;
                    }

                    if ( 0 <= y - 1 && field[x][y-1] == 'P')
                        score++;
                    if (y + 1 < field[x].length && field[x][y+1] == 'P')
                        score++;
                    if (0 <= x - 1 && field[x-1][y] == 'P')
                        score++;
                    if (x + 1 < field.length && field[x+1][y] == 'P')
                        score++;
                    if (1 <= score) {
                        isFailure = true;
                        break;
                    }
                }
            }
            if (!isFailure) { answer[i] = 1; }
        }

        return answer;
    }
}