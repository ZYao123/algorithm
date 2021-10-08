package com.leetcode;

import java.util.*;

public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] arr = new Node[numCourses];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Node();
        }
        for (int[] p : prerequisites) {
            arr[p[1]].nexts.add(arr[p[0]]);
            arr[p[0]].pre++;
        }
        for (int i = 0; i < numCourses; i++) {
            int idx = findZero(arr);
            if (idx == -1)
                return false;
            Node node = arr[idx];
            node.pre = -1;
            for (Node n : node.nexts) {
                n.pre--;
            }
        }
        return true;
    }

    private int findZero(Node[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].pre == 0)
                return i;
        }
        return -1;
    }

    class Node {
        ArrayList<Node> nexts;
        int pre;

        public Node() {
            this.nexts = new ArrayList<>();
            this.pre = 0;
        }
    }
}
