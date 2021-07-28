public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;

        for (int r = 0; r < offset + lock.length; ++r) {
            for (int c = 0; c < offset + lock.length; ++c) {
                //4방향 회전
                for (int rot = 0; rot < 4; ++rot) {
                    int[][] arr = new int[58][58];
                    for (int i = 0; i < lock.length; ++i) {
                        for(int j = 0; j < lock.length; ++j) {
                            arr[offset + i][offset + j] = lock[i][j];
                        }
                    }
                    match(arr, key, rot, r, c);
                    if(check(arr, offset, lock.length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(int[][] arr, int offset, int n) {
        for ( int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (arr[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void match(int[][] arr, int[][] key, int rot, int r, int c) {
        int n = key.length - 1;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if(rot == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if (rot == 1) {//90도
                    arr[r + i][c + j] += key[j][n - i]; 
                } else if (rot == 2) { // 180도
                    arr[r + i][c + j] += key[n - i][n - j];
                } else {
                    arr[r + i][c + j] += key[n - j][i];
                }
            }
        }
    }