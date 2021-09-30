package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_437 {
//    int count = 0;
//
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null)
//            return 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
//        helper(map, root, 0, targetSum);
//        return count;
//    }
//
//    private void helper(Map<Integer, Integer> map, TreeNode node, int val, int targetSum) {
//        if (node == null)
//            return;
//        node.val += val;
//        count += map.getOrDefault(node.val - targetSum, 0);
//        map.compute(node.val, (k, v) -> v == null ? 1 : v + 1);
//        helper(map, node.left, node.val, targetSum);
//        helper(map, node.right, node.val, targetSum);
//        map.compute(node.val, (k, v) -> v - 1);
//    }


    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x1 =  Math.max(Math.min(ax1,ax2),Math.min(bx1,bx2));
        int x2 = Math.min(Math.max(ax1,ax2),Math.max(bx1,bx2));
        int y1 =  Math.max(Math.min(ay1,ay2),Math.min(by1,by2));
        int y2 = Math.min(Math.max(ay1,ay2),Math.max(by1,by2));
        System.out.println(Math.abs(ax2-ax1) * Math.abs(ay2 - ay1));
        System.out.println(Math.abs(bx2-bx1) * Math.abs(by2 - by1));
        System.out.println((x2-x1) * (y2-y1));
        return Math.abs(ax2-ax1) * Math.abs(ay2 - ay1) + Math.abs(bx2-bx1) * Math.abs(by2 - by1)  - (x2-x1) * (y2-y1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Integer, Integer> prefix, int curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
