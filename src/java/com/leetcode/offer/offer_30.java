package com.leetcode.offer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class offer_30 {
    class MinStack {

        /**
         * initialize your data structure here.
         */
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
            if (s2.isEmpty() || x <= s2.peek())
                s2.add(x);
        }

        public void pop() {
            if (s1.pop().equals(s2.peek()))
                s2.pop();
        }

        public int top() {
            return s1.peek();
        }

        public int min() {
            return s2.peek();
        }
    }
}
