package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_282 {
    List<String> res = new ArrayList<>();
    char[] chars;
    int t;

    public List<String> addOperators(String num, int target) {
        chars = num.toCharArray();
        t = target;
        StringBuilder str = new StringBuilder();
        str.append(chars[0]);
        helper(1, chars[0] - '0', str);
        return res;
    }

    private void helper(int idx, int sum, StringBuilder str) {
        if (idx == chars.length) {
            if (sum == t)
                res.add(str.toString());
        }
        int n = 0;
        for (int i = idx; i < chars.length; i++) {
            n = n * 10 + (chars[idx] - 'a');
            str.append('+').append(n);
            helper(i + 1, sum + n, str);
            System.out.println(idx + "-" + sum + "-" + str);
            str.setLength(str.length() - (i - idx + 2));
            System.out.println(idx + "-" + sum + "-" + str);

            str.append('-').append(n);
            helper(i + 1, sum - n, str);
            str.setLength(str.length() - (i - idx + 2));

            str.append('*').append(n);
            helper(i + 1, sum * n, str);
            str.setLength(str.length() - (i - idx + 2));
        }
    }
}
