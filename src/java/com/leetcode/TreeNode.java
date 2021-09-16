package com.leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


//    public static void swap(int[] nums, int l, int r) {
//        int t = nums[l];
//        nums[l] = nums[r];
//        nums[r] = t;
//    }
}