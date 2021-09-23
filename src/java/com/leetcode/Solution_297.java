package com.leetcode;

import java.util.*;

public class Solution_297 {
    // Encodes a tree to a single string.
//    TreeNode flag = new TreeNode(-1);

    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        List<TreeNode> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int count = 0;
        int nullCount = 0;
        while (!list.isEmpty()) {
            if (nullCount > count / 2)
                break;
            TreeNode temp = list.removeFirst();
            if (temp == null) {
                nullCount++;
                list.addLast(null);
                list.addLast(null);
            } else {
                nullCount = 0;
                list.addLast(temp.left);
                list.addLast(temp.right);
            }
            count++;
            res.add(temp);
        }
        count -= nullCount;
        StringBuilder builder = new StringBuilder('[');

        for (int i = 0; i < count; i++) {
            TreeNode node = res.get(i);
            if (node == null) {
                builder.append("null").append(',');
            } else {
                builder.append(node.val).append(',');
            }
        }
        builder.setCharAt(builder.length() - 1, ']');
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        System.out.println(data);
        String str = data.substring(1, data.length() - 1);
        if (str.length() == 0)
            return null;
        String[] split = str.split(",");
        if (split.length == 0) {
            return null;
        }
        String s = split[0];
        System.out.println(s);
        System.out.println(Arrays.toString(split));
        TreeNode root = new TreeNode(Integer.parseInt(s));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < split.length; i += 2) {
            TreeNode node = list.removeFirst();
            if (node == null)
                continue;
            if ("null".equals(split[i])) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(split[i]));
            }
            if (i + 1 < split.length) {
                if ("null".equals(split[i + 1])) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(split[i + 1]));
                }
            }
            list.addLast(node.left);
            list.addLast(node.right);
        }
        return root;
    }
}
