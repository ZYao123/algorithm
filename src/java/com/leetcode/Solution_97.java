package com.leetcode;

public class Solution_97 {
    class Solution {
        TreeNode pre = null;

        public TreeNode increasingBST(TreeNode root) {
            increasingBST(root.left);
            if (pre != null) {
                pre.right = root;
            }
            pre = root;
            increasingBST(root.right);
            return root;
        }
    }
}