package com.leetcode;

public class Solution_639 {
//    public int numDecodings(String s) {
//        if (s.length() == 0)
//            return 0;
//        int[] dp = new int[s.length()];
//        char[] chs = s.toCharArray();
//
//        dp[0] = chs[0] == '*' ? 9 : 1;
//        for (int i = 1; i < chs.length; i++) {
//            if (chs[i] == '*') {
//                int c1 = dp[i - 1] * 9 % 1000000007;
//                int c2 = 0;
//                if (chs[i] == '1')
//                    c2 = 9;
//                else if (chs[i] == '2')
//                    c2 = 6;
//                c2 = i == 1 ? c2 : dp[i - 2] * c2 % 1000000007;
//                dp[i] = (c1 + c2) % 1000000007;
//            } else if (chs[i] == '0') {
//                if (dp[i - 1] == '*')
//                    dp[i] = dp[i - 2] * 2 % 1000000007;
//                else if (dp[i - 1] == '1' || dp[i - 1] == '2')
//                    dp[i] = dp[i - 1];
//                else
//                    return 0;
//            } else {
//                if (dp[i - 1] == '*')
//                    dp[i] = dp[i - 2] * 3 % 1000000007;
//                else if (dp[i - 1] == '1' || dp[i - 1] == '2')
//                    dp[i] = dp[i - 2] * 2 % 1000000007;
//                else
//                    dp[i] = dp[i - 1];
//            }
//        }
//        return dp[dp.length - 1];
//    }

    static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }
}
