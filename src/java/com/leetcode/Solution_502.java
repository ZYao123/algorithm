package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] arr = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        Queue<int[]> able = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int res = 0;

        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < arr.length && arr[idx][1] <= w) {
                able.add(arr[idx++]);
            }
            if (able.isEmpty())
                return res;
            res += able.poll()[0];
        }
        return res;
    }
}
