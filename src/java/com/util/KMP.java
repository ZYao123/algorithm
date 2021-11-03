package com.util;

import org.junit.Test;

public class KMP {

    @Test
    public void test() {

    }


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
