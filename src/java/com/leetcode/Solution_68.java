package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; ) {
            int len = 0;
            int step = 0;
            while (len + (step - 1) + words[i + step].length() < maxWidth) {
                len += words[i + step].length();
                step++;
                if (i + step >= words.length) {
                    StringBuilder builder = new StringBuilder();
                    for (int j = i; j < words.length; j++) {
                        builder.append(words[j]).append(' ');
                    }
                    builder.setLength(builder.length() - 1);
                    while (builder.length() < maxWidth)
                        builder.append(' ');
                    res.add(builder.toString());
                    return res;
                }
            }
            if (step == 1) {
                StringBuilder builder = new StringBuilder(words[i]);
                while (builder.length() < maxWidth)
                    builder.append(' ');
                res.add(builder.toString());
                i += step;
                continue;
            }
            int lr = len;
            int[] sp = new int[step - 1];
            int s = maxWidth - lr;
            int sidx = 0;
            while (s > 0) {
                sp[sidx % sp.length]++;
                s--;
                sidx++;
            }
            StringBuilder builder = new StringBuilder(words[i]);
            for (int j = 0; j < sp.length; j++) {
                for (int k = 0; k < sp[j]; k++) {
                    builder.append(' ');
                }
                builder.append(words[i + j + 1]);
            }
            res.add(builder.toString());
            i += step;
        }
        return res;
    }
}
