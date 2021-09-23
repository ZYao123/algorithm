package unit;

import com.leetcode.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class treeTest {
    @Test
    public void treeTester() {
//        Integer[] arr = new Integer[]{4, 1, 3, 9, null, null, 2};
//        LinkedList<TreeNode> list = new LinkedList<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (list.isEmpty()) {
//                TreeNode temp = new TreeNode(arr[i]);
//                list.addLast(temp);
//                continue;
//            }
//
//        }

        TreeNode treeNode = stringToTreeNode("[1,2,3,null,null,4,5]");
        treeNode.printTree();
//        printTree3(treeNode);
//        System.out.println("--------");
//        printTrees3(treeNode);
    }

    // 前序遍历
    public static void printTree1(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.println(treeNode.val);
        printTree1(treeNode.left);
        printTree1(treeNode.right);
    }

    public static void printTrees1(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            System.out.println(t.val);
            if (t.right != null)
                stack.add(t.right);
            if (t.left != null)
                stack.add(t.left);
        }
    }


    // 中序遍历 2 1 4 3 5
    public static void printTree2(TreeNode treeNode) {
        if (treeNode == null)
            return;
        printTree3(treeNode.left);
        System.out.println(treeNode.val);
        printTrees3(treeNode.right);
    }

    public static void printTrees2(TreeNode treeNode) {
        if (treeNode == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = treeNode;
        while (!stack.isEmpty() || pre != null) {
            if (pre != null) {
                stack.add(pre);
                pre = pre.left;
            } else {
                pre = stack.pop();
                System.out.println(pre.val);
                pre = pre.right;
            }
        }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = treeNode;
//        while (cur != null) {
//            stack.add(cur);
//            cur = cur.left;
//        }
//        while (!stack.isEmpty()) {
//            TreeNode pop = stack.pop();
//            System.out.println(pop.val);
//            if (pop.right != null) {
//                cur = pop.right;
//                while (cur != null) {
//                    stack.add(cur);
//                    cur = cur.left;
//                }
//            }
//        }
    }

    // 后序遍历2 4 5 3 1
    public static void printTree3(TreeNode treeNode) {
        if (treeNode == null)
            return;
        printTree3(treeNode.left);
        printTree3(treeNode.right);
        System.out.println(treeNode.val);
    }

    public static void printTrees3(TreeNode treeNode) {
        if (treeNode == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stack2.add(pop);
            if (pop.left != null)
                stack.add(pop.left);
            if (pop.right != null)
                stack.add(pop.right);
        }
        while (!stack2.isEmpty())
            System.out.println(stack2.pop().val);
    }


    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
