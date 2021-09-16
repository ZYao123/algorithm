package com.leetcode;

public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
//        helper(nums, 0, nums.length - 1, k);
//        return nums[k];
        build(nums, k);
        for (int i = k + 1; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, i, 0);
                adjust(nums, 0, k);
            }
        }
        return nums[0];
    }

    private void build(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjust(arr, i, len);
        }
    }

    private void adjust(int[] arr, int i, int len) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int min = i;
        if (l < len && arr[min] > arr[l]) {
            min = l;
        }
        if (r < len && arr[min] > arr[r]) {
            min = r;
        }
        if (min != i) {
            swap(arr, i, min);
            adjust(arr, min, len);
        }
    }


    //    private void helper(int[] nums, int l, int r, int k) {
//        while (l < r) {
//            while (r > k && nums[r] <= nums[l])
//                r--;
//            while (l < k && nums[l] <= nums[r])
//                l++;
//
//            if (l < r) {
//                swap(nums, l, r);
//            }
//        }
//    }
//
    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }


//    Random random = new Random();
//
//    public int findKthLargest(int[] nums, int k) {
//        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
//    }
//
//    public int quickSelect(int[] a, int l, int r, int index) {
//        int q = randomPartition(a, l, r);
//        if (q == index) {
//            return a[q];
//        } else {
//            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
//        }
//    }
//
//    public int randomPartition(int[] a, int l, int r) {
//        int i = random.nextInt(r - l + 1) + l;
//        swap(a, i, r);
//        return partition(a, l, r);
//    }
//
//    public int partition(int[] a, int l, int r) {
//        int x = a[r], i = l - 1;
//        for (int j = l; j < r; ++j) {
//            if (a[j] <= x) {
//                swap(a, ++i, j);
//            }
//        }
//        swap(a, i + 1, r);
//        return i + 1;
//    }
}
