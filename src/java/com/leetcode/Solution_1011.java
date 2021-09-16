package com.leetcode;

public class Solution_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int l = 0, r = 0;
        for (int weight : weights) {
            r += weight;
            if (weight > l) l = weight;
        }
        while (l < r) {
            int d = 0;
            int s = 0;
            int mid = (l + r) / 2;
            for (int i = 0; i < weights.length; i++) {
                if (s + weights[i] > mid) {
                    s = 0;
                    d++;
                }
                s += weights[i];
            }
            if (d < D)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
