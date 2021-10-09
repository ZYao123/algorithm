package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_51 {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] cache = new boolean[n][n];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        boolean[] check = new boolean[n];
        helper(cache, set1, set2, check, 0);
        return res;
    }

    private void helper(boolean[][] cache, HashSet<Integer> set1, HashSet<Integer> set2, boolean[] check, int n) {
        if (n == cache.length) {
            List<String> cur = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            for (boolean[] bs : cache) {
                for (boolean b : bs) {
                    str.append(b ? 'Q' : '.');
                }
                cur.add(str.toString());
                str.setLength(0);
            }
            res.add(cur);
            return;
        }

        for (int i = 0; i < cache.length; i++) {
            if (set1.contains(n + i) || set2.contains(n - i))
                continue;
            if (check[i])
                continue;
            cache[n][i] = true;
            check[i] = true;
            set1.add(n + i);
            set2.add(n - i);
            helper(cache, set1, set2, check, n + 1);
            cache[n][i] = false;
            check[i] = false;
            set1.remove(n + i);
            set2.remove(n - i);
        }
    }
}
