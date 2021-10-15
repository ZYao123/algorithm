package com.leetcode;

public class Solution_38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int k = 1; k < n; k++) {
            StringBuilder newStr = new StringBuilder();
            char preC = str.charAt(0);
            int count = 0;
            for (int idx = 0; idx < str.length(); idx++) {
                char c = str.charAt(idx);
                if (c == preC) {
                    count++;
                } else {
                    newStr.append(count).append(preC);
                    preC = c;
                    count = 1;
                }
            }
            newStr.append(count).append(preC);
            str = newStr.toString();
        }
        return str;
    }
}
