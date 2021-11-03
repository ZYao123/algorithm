package com.leetcode;

import java.util.PriorityQueue;

public class Solution_407 {
//    public int trapRainWater(int[][] heightMap) {
//        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
//            return 0;
//        }
//        int m = heightMap.length;
//        int n = heightMap[0].length;
//        boolean[][] visit = new boolean[m][n];
//        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
//
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
//                    pq.offer(new int[]{i * n + j, heightMap[i][j]});
//                    visit[i][j] = true;
//                }
//            }
//        }
//        int res = 0;
//        int[] dirs = {-1, 0, 1, 0, -1};
//        while (!pq.isEmpty()) {
//            int[] curr = pq.poll();
//            for (int k = 0; k < 4; ++k) {
//                int nx = curr[0] / n + dirs[k];
//                int ny = curr[0] % n + dirs[k + 1];
//                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
//                    if (curr[1] > heightMap[nx][ny]) {
//                        res += curr[1] - heightMap[nx][ny];
//                    }
//                    pq.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], curr[1])});
//                    visit[nx][ny] = true;
//                }
//            }
//        }
//        return res;
//    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0, heightMap[i][0]});
            queue.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            visit[i][0] = true;
            visit[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            queue.add(new int[]{0, i, heightMap[0][i]});
            queue.add(new int[]{m - 1, i, heightMap[m - 1][i]});
            visit[0][i] = true;
            visit[m - 1][i] = true;
        }
        int res = 0;
        int[] map = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + map[i];
                int y = poll[1] + map[i + 1];
                if (x >= 0 && y >= 0 && x < m && y < n && !visit[x][y]) {
                    if (poll[2] > heightMap[x][y]) {
                        res += poll[2] - heightMap[x][y];
                    }
                    queue.add(new int[]{x, y, Math.max(poll[2], heightMap[x][y])});
                    visit[x][y] = true;
                }
            }
        }
        return res;
    }
}
