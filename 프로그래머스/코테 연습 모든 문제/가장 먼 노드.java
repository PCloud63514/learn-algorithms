package com.pcloud.jcodetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


@SpringBootTest
class JCodeTestApplicationTests {

    @Test
    public void main() {
        Assertions.assertEquals(3, solution(6, new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}}));
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] depths = new int[n + 1];
        boolean[][] graph = new boolean[n + 1][n + 1];
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(1);

        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]][edge[i][1]] = true;
            graph[edge[i][1]][edge[i][0]] = true;
        }

        int maxDepth = 0;

        while(nodes.isEmpty() == false) {
            int node = nodes.poll();
            // 1부터 시작이므로 2
            for(int i = 2; i <= n; i++) {
                // depths 계산이 되지 않았고 graph 의 값이 존재할 때.
                if(depths[i] == 0 && graph[node][i]) {
                    // depths[i] = 노드의 깊이 + 1
                    depths[i] = depths[node] + 1;
                    nodes.add(i);
                    maxDepth = Math.max(maxDepth, depths[i]);
                }

            }
        }

        for(int depth : depths) {
            if(depth == maxDepth) {
                answer++;
            }
        }

        return answer;
    }
}