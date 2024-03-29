package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: yuanrui
 */
public class MinimumMoves {

    int[][] grid;
    boolean[][] visited;
    int ans = 0;

    public int minimumMoves(int[][] grid) {
        this.grid = grid;
        visited = new boolean[3][3];

        for(int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (grid[i][j] == 0) {
                    // 从附近的有石人拿点石头
                    bfs(i, j);
                    for (boolean[] booleans : visited) {
                        Arrays.fill(booleans, false);
                    }

                }
            }
        }

        return ans;
    }

    private void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        while (grid[i][j] != 1 && !queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollx = poll[0];
            int polly = poll[1];
            if (pollx - 1 >= 0 && !visited[pollx - 1][polly]) {
                if (grid[i][j] != 1 && grid[pollx - 1][polly] > 1) {
                    ans += (Math.abs(pollx - 1 - i) + Math.abs(polly - j));
                    grid[pollx - 1][polly]--;
                    grid[i][j] = 1;
                }
                queue.add(new int[]{pollx - 1, polly});
                visited[pollx - 1][polly] = true;
            }
            if (pollx + 1 < 3 && !visited[pollx + 1][polly]) {
                if (grid[i][j] != 1 && grid[pollx + 1][polly] > 1) {
                    ans += (Math.abs(pollx + 1 - i) + Math.abs(polly - j));
                    grid[pollx + 1][polly]--;
                    grid[i][j] = 1;
                }
                queue.add(new int[]{pollx + 1, polly});
                visited[pollx + 1][polly] = true;
            }

            if (polly - 1 >= 0 && !visited[pollx][polly - 1]) {
                if (grid[i][j] != 1 && grid[pollx][polly - 1] > 1) {
                    ans += (Math.abs(pollx - i) + Math.abs(polly - 1 - j));
                    grid[pollx][polly - 1]--;
                    grid[i][j] = 1;
                }
                queue.add(new int[]{pollx, polly - 1});
                visited[pollx][polly - 1] = true;
            }
            if (polly + 1 < 3 && !visited[pollx][polly + 1]) {
                if (grid[i][j] != 1 && grid[pollx][polly + 1] > 1) {
                    ans += (Math.abs(pollx - i) + Math.abs(polly + 1 - j));
                    grid[pollx][polly + 1]--;
                    grid[i][j] = 1;
                }
                queue.add(new int[]{pollx, polly + 1});
                visited[pollx][polly + 1] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,2},{1,1,0},{0,1,1}};

        MinimumMoves minimumMoves = new MinimumMoves();
        System.out.println(minimumMoves.minimumMoves(grid));
    }
}
