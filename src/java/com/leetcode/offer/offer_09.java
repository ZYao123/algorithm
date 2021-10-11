package com.leetcode.offer;

import java.util.Stack;

public class offer_09 {
    class CQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s2.push(value);
        }

        public int deleteHead() {
            if (s1.isEmpty()) {
                while (!s2.isEmpty())
                    s1.push(s2.pop());
            }
            return s1.isEmpty() ? -1 : s1.pop();
        }
    }

}
