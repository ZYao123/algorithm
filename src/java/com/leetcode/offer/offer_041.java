package com.leetcode.offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class offer_041 {

    Queue<Integer> left;
    Queue<Integer> right;

    public void MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty()) {
            left.add(num);
            return;
        }
        while (!left.isEmpty() && left.peek() > num) right.add(left.poll());
        while (!right.isEmpty() && right.peek() < num) left.add(right.poll());
        left.add(num);
        while (left.size() - 1 > right.size()) left.add(right.poll());
        while (right.size() > left.size()) right.add(left.poll());
    }

    public double findMedian() {
        if (left.size() == right.size())
            return (double) (left.peek() + right.peek()) / 2;
        else
            return left.peek();
    }

//
//    class MedianFinder {
//        Queue<Integer> pre;
//        Queue<Integer> after;
//
//        /**
//         * initialize your data structure here.
//         */
//        public MedianFinder() {
//            pre = new PriorityQueue<>((a, b) -> b - a);
//            after = new PriorityQueue<>();
//        }
//
//        public void addNum(int num) {
//            if (pre.isEmpty()) {
//                pre.add(num);
//                return;
//            }
//            int peek = pre.peek();
//            if (peek < num) {
//                after.add(num);
//            } else {
//                pre.add(num);
//            }
//            if (pre.size() - after.size() >= 2) {
//                after.add(pre.poll());
//            } else if (after.size() - pre.size() >= 1) {
//                pre.add(after.poll());
//            }
//        }
//
//        public double findMedian() {
//            Integer p = pre.peek();
//            p = p == null ? 0 : p;
//            if ((pre.size() + after.size() & 1) == 1) {
//                return (double) p;
//            } else {
//                Integer a = after.peek();
//                a = a == null ? 0 : a;
//                return ((double) p + (double) a) / 2;
//            }
//        }
//    }

}
