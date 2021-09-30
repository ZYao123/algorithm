package com.leetcode.lcs;

public class lcs_03 {
    boolean flag = false;
    int count = 0;

    public int largestArea(String[] grid) {
        char[][] arr = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            arr[i] = grid[i].toCharArray();
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                char c = arr[i][j];
                if (c >= '1' && c <= '5') {
                    flag = true;
                    count = 0;
                    helper(arr, i, j, c);
                    if (flag && count > res) {
                        System.out.println(count + " " + i + " " + j);
                        res = count;
                    }
                }
            }
        }
        return res;
    }

    private void helper(char[][] arr, int i, int j, char c) {
        if (i < 0 || j < 0 || i == arr.length || j == arr[i].length || arr[i][j] == '0') {
            flag = false;
            return;
        }
        if (arr[i][j] != c)
            return;
        count++;
        arr[i][j] = '7';
        helper(arr, i - 1, j, c);
        helper(arr, i + 1, j, c);
        helper(arr, i, j - 1, c);
        helper(arr, i, j + 1, c);
    }
}
