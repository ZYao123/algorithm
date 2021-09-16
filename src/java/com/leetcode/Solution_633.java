package com.leetcode;

public class Solution_633 {
    public boolean judgeSquareSum(int c) {
        int r1 = (int) Math.sqrt(c);
        for (int l1 = 0; l1 <= r1; l1++) {
            int b = c - l1 * l1;
            if (b % 10 == 2 || b % 10 == 3 || b % 10 == 7 || b % 10 == 8)
                continue;

        }
        return false;
    }
}
