package com.leetcode;

public class Solution_124 {
    int max = -2000;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        max = Math.max(left + right + root.val, max);
        return Math.max(left, right) + root.val;
    }


//    public String reverseWords(String s) {
//        Arrays.binarySearch()
//    }
//    int[] cache;
//
//    public Solution(int[] w) {
//        cache = new int[w.length];
//        if (w.length > 0) {
//            cache[0] = w[0];
//            for (int i = 1; i < w.length; i++) {
//                cache[i] = cache[i - 1] + w[i];
//            }
//        }
//    }
//
//    Random rand = new Random();
//
//    public int pickIndex() {
//        if (cache.length <= 1)
//            return 0;
//        int i = Math.random()
//        int i = rand.nextInt(cache[cache.length - 1] - cache[0] + 1) + cache[0];
//        int l = 0, r = cache.length - 1;
//        while (l < r) {
//            int mid = (l + r) / 2;
//            if (cache[mid] < i) {
//                l = mid + 1;
//            } else {
//                r = mid;
//            }
//        }
//        return l;
//    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                res[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + res[i];
        }
        return res;
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];
        res[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != '0')
                res[i] += res[i - 1];
            int p = chars[i - 1] - '0';
            if (chars[i] >= '0' && chars[i] <= '6' && (chars[i - 1] == '1' || chars[i - 1] == '2'))
                res[i] += res[i - 2] + 1;
        }
        return res[chars.length - 1];
    }

    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        for (int i = 0; i < s1.length || i < s2.length; i++) {
            int a = 0;
            if (i < s1.length) {
                a = Integer.parseInt(s1[i]);
            }
            int b = 0;
            if (i < s2.length) {
                b = Integer.parseInt(s2[i]);
            }
            if (a > b)
                return 1;
            else if (a < b)
                return -1;
        }
        return 0;
    }

//    public int calculate(String s) {
//        Stack<String> stack = new Stack<>();
//        char[] charArray = s.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            char c = charArray[i];
//            if (c == ' ')
//                continue;
//
//
//        }
//    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        System.out.println();
//        TreeNode temp = root;
//        while (temp.val != key) {
//            if (temp.val > key)
//                temp = temp.left;
//            else
//                temp = temp.right;
//        }
//
//    }

//        int l = 0, r = cache.length - 1;
//        while (l < r) {
//            int mid = (l + r) / 2;
//            if (mid == cache.length - 1 || cache[mid] == i) {
//                return mid;
//            }
//            if (cache[mid] < i && i <= cache[mid + 1]) {
//                return mid;
//            }
//            if (cache[mid] > i) {
//                r = mid;
//            }
//            if (cache[mid] < i) {
//                l = mid;
//            }
//        }

}
