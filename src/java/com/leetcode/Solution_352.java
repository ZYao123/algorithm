package com.leetcode;

import java.util.*;

public class Solution_352 {
//    class SummaryRanges {
//        boolean[] cache;
//
//        public SummaryRanges() {
//            cache = new boolean[10002];
//        }
//
//        public void addNum(int val) {
//            cache[val] = true;
//        }
//
//        public int[][] getIntervals() {
//            int start = -1;
//            ArrayList<int[]> res = new ArrayList<>();
//            for (int i = 0; i <= 10000; i++) {
//                if (cache[i] && start == -1) {
//                    start = i;
//                }
//                if (!cache[i + 1] && start != -1) {
//                    res.add(new int[]{start, i});
//                    start = -1;
//                }
//            }
//            int[][] r = new int[res.size()][2];
//            for (int i = 0; i < res.size(); i++) {
//                r[i] = res.get(i);
//            }
//            return r;
//        }
//    }


//    class SummaryRanges {
//        TreeSet<Integer> cache;
//
//        public SummaryRanges() {
//            cache = new TreeSet<>();
//        }
//
//        public void addNum(int val) {
//            cache.add(val);
//        }
//
//        public int[][] getIntervals() {
//            int start = -1;
//            ArrayList<int[]> res = new ArrayList<>();
//
//            Iterator<Integer> it = cache.iterator();
//            int pre = 0;
//            while (it.hasNext()) {
//                int cur = it.next();
//                if (start != -1 && cur != pre + 1) {
//                    res.add(new int[]{start, pre});
//                    start = -1;
//                }
//                if (start == -1) {
//                    start = cur;
//                }
//                pre = cur;
//            }
//            if (start != -1) res.add(new int[]{start, pre});
//
//            int[][] r = new int[res.size()][2];
//            for (int i = 0; i < res.size(); i++) {
//                r[i] = res.get(i);
//            }
//            return r;
//        }
//    }


    class SummaryRanges {
        TreeMap<Integer, Integer> intervals;

        public SummaryRanges() {
            intervals = new TreeMap<Integer, Integer>();
        }

        public void addNum(int val) {
            // 找到 l1 最小的且满足 l1 > val 的区间 interval1 = [l1, r1]
            // 如果不存在这样的区间，interval1 为尾迭代器
            Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);
            // 找到 l0 最大的且满足 l0 <= val 的区间 interval0 = [l0, r0]
            // 在有序集合中，interval0 就是 interval1 的前一个区间
            // 如果不存在这样的区间，interval0 为尾迭代器
            Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);

            if (interval0 != null && interval0.getKey() <= val && val <= interval0.getValue()) {
                // 情况一
                return;
            } else {
                boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
                boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;
                if (leftAside && rightAside) {
                    // 情况四
                    int left = interval0.getKey(), right = interval1.getValue();
                    intervals.remove(interval0.getKey());
                    intervals.remove(interval1.getKey());
                    intervals.put(left, right);
                } else if (leftAside) {
                    // 情况二
                    intervals.put(interval0.getKey(), interval0.getValue() + 1);
                } else if (rightAside) {
                    // 情况三
                    int right = interval1.getValue();
                    intervals.remove(interval1.getKey());
                    intervals.put(val, right);
                } else {
                    // 情况五
                    intervals.put(val, val);
                }
            }
        }

        public int[][] getIntervals() {
            int size = intervals.size();
            int[][] ans = new int[size][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                int left = entry.getKey(), right = entry.getValue();
                ans[index][0] = left;
                ans[index][1] = right;
                ++index;
            }
            return ans;
        }
    }

//    class SummaryRanges {
//        HashMap<Integer, int[]> m1;
//        HashMap<Integer, int[]> m2;
//
//        public SummaryRanges() {
//            m1 = new HashMap<>();
//            m2 = new HashMap<>();
//        }
//
//        public void addNum(int val) {
//            int[] res = new int[]{val, val};
//            int[] ints1 = m1.remove(val - 1);
//            if (ints1 != null) {
//                res[0] = ints1[0];
//                m2.remove(res[0]);
//            }
//            int[] ints2 = m2.remove(val + 1);
//            if (ints2 != null) {
//                res[1] = ints2[1];
//                m1.remove(res[1]);
//            }
//            m1.put(res[1], res);
//            m2.put(res[0], res);
//        }
//
//        public int[][] getIntervals() {
//            int[][] r = new int[m1.size()][2];
//            int idx = 0;
//            for (int[] value : m1.values()) {
//                r[idx++] = value;
//            }
//            return r;
//        }
//    }
}
