package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_51 {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[] cache = new int[n];
        boolean[] c = new boolean[n];
        boolean[] c1 = new boolean[n * 2];
        boolean[] c2 = new boolean[n * 2];
        helper(cache, c, c1, c2, 0);
        return res;
    }

    private void helper(int[] cache, boolean[] c, boolean[] c1, boolean[] c2, int k) {
        if (k == cache.length) {
            List<String> cur = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            for (int idx : cache) {
                for (int i = 0; i < cache.length; i++) {
                    str.append(i == idx ? 'Q' : '.');
                }
                cur.add(str.toString());
                str.setLength(0);
            }
            res.add(cur);
            return;
        }
        for (int i = 0; i < cache.length; i++) {
            if (c[i] || c1[k + i] || c2[k - i + cache.length])
                continue;
            c[i] = true;
            c1[k + i] = true;
            c2[k - i + cache.length] = true;
            cache[k] = i;
            helper(cache, c, c1, c2, k + 1);
            c[i] = false;
            c1[k + i] = false;
            c2[k - i + cache.length] = false;
            cache[k] = -1;
        }
    }
}
