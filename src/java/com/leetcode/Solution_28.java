package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_28 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(nextArr("ababa".toCharArray())));
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(strStr(str, match));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int t = target * 2;
        for (int i = 2; i < target / 2; i++) {
            if (t % i != 0) continue;
            int[] cur = new int[i];
            int b = target / i - (i - 1) / 2;
            for (int j = 0; j < i; j++) {
                cur[j] = b++;
            }
            list.add(cur);
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res, (a, b) -> a[0] - b[0]);
        return res;
    }


    //  KMP
    public int strStr(String haystack, String needle) {
        char[] arr = haystack.toCharArray();
        char[] chs = needle.toCharArray();
        int[] next = nextArr(chs);
        int i1 = 0, i2 = 0;
        while (i1 < arr.length && i2 < chs.length) {
            if (arr[i1] == chs[i2]) {
                i1++;
                i2++;
            } else if (i2 == 0) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == chs.length ? i1 - i2 : -1;
    }

    private int[] nextArr(char[] str) {
        if (str.length == 0) return new int[0];
        int[] next = new int[str.length];
        next[0] = -1;
        if (str.length == 1) return next;
        next[1] = 0;
        int idx = 0;
        int i = 2;
        while (i < next.length) {
            if (str[idx] == str[i - 1]) {
                next[i++] = ++idx;
            } else if (idx == 0) {
                next[i++] = 0;
            } else {
                idx = next[idx];
            }
        }
        return next;
    }
}
