package com.learn.graph;

import java.util.HashSet;
import java.util.Stack;

public class DFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }

    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder builder = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }
            if (c <= 'z') {
                c = (char) (c - 'a' + 'A');
            }
            if (cur.length() >= k) {
                System.out.println(cur);
                builder.insert(0, cur).insert(0, '-');
                cur = new StringBuilder();
            }
            cur.insert(0, c);
        }
        if (cur.length() == 0) {
            builder.delete(0, 1);
        } else {
            builder.insert(0, cur);
        }
        return builder.toString();
    }

}