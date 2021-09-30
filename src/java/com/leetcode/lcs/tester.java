package com.leetcode.lcs;

import org.junit.Test;

public class tester {
    @Test
    public void lcs_03Tester() {
        String[] strs = {"02520253", "51551213", "03512513", "34312132", "21051025", "52005131", "34235150", "22154013"};
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        lcs_03 l = new lcs_03();
        l.largestArea(strs);
    }

}
