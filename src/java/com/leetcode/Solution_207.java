package com.leetcode;

public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] t = prerequisites[i];
            arr[t[0]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            int idx = findZero(prerequisites, arr);
            if (idx == -1)
                return false;
            arr[idx] = -1;
            arr[prerequisites[idx][0]]--;
        }
        return true;
    }

    private int findZero(int[][] prerequisites, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
