public void Solution2() {
    int n = 3;
    int[][] computers = { {1,1,0}, {1,1,0}, {0,0,1}};
    int byAnswer = 2;
    int answer = 0;
    for(int i = 0; i < n; i++) {
        if(computers[i][i] == 1) {
            dfs(computers, i);
            answer += 1;
        }
    }
    Assertions.assertEquals(answer, byAnswer);
}

public static void dfs(int[][] computers, int n) {
    if(computers[n][n] == 0) {
        return;
    }
    computers[n][n] = 0;
    for(int i = 0; i < computers.length; i++) {
        if(computers[n][i] == 1) {
            dfs(computers, i);
        }
    }
}