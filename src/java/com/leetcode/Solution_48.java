package com.leetcode;

public class Solution_48 {
    public void rotate(int[][] matrix) {
        System.out.println();
        int n = matrix.length;
        int temp = -2000;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int a = i, b = j;
                for (int k = 0; k < 4; k++) {
                    temp = a;
                    a = n - b - 1;
                    b = n - temp - 1;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[a][b];
                    matrix[a][b] = temp;
                }
            }
        }
    }

//    private void swap(int[] nums, int l, int r) {
//        int t = nums[l];
//        nums[l] = nums[r];
//        nums[r] = t;
//    }
}
