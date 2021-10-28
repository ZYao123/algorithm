package com.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class sortTest {
    @Test
    public void SortTester() {
        int size = 10;
        boolean success = true;
        for (int testCount = 0; testCount < 1000; testCount++) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = (int) (Math.random() * size * size);
            }
            int[] arr1 = Arrays.copyOf(arr, arr.length);
//            if (testCount % 3 == 0)
//                heapSort(arr1);
//            if (testCount % 3 == 1)
//                mergeSort(arr1);
//            if (testCount % 3 == 2)
            quickSort(arr1);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            Assert.assertArrayEquals(arr1, arr2);
        }
    }

    private void heapSort(int[] arr) {
        for (int i = arr.length / 2 + 1; i >= 0; i--) {
            adjust(arr, arr.length - 1, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjust(arr, i - 1, 0);
        }
    }

    private void adjust(int[] arr, int length, int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        if (right <= length) {
            int maxIdx = idx;
            if (arr[left] > arr[maxIdx])
                maxIdx = left;
            if (arr[right] > arr[maxIdx])
                maxIdx = right;
            if (idx != maxIdx) {
                swap(arr, idx, maxIdx);
                adjust(arr, length, maxIdx);
            }
        } else if (left <= length) {
            if (arr[left] > arr[idx]) {
                swap(arr, left, idx);
                adjust(arr, length, left);
            }
        }
    }


    private void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int begin, int end) {
        if (begin == end)
            return;
        else if (end - begin == 1) {
            if (arr[begin] > arr[end])
                swap(arr, begin, end);
            return;
        }
        int mid = ((end - begin) >> 1) + begin;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        int idx = 0;
        int idx1 = begin;
        int idx2 = mid + 1;
        int[] temp = new int[end - begin + 1];
        while (idx1 <= mid && idx2 <= end) {
            temp[idx++] = arr[idx1] < arr[idx2] ? arr[idx1++] : arr[idx2++];
        }
        while (idx1 <= mid)
            temp[idx++] = arr[idx1++];
        while (idx2 <= end)
            temp[idx++] = arr[idx2++];
        for (int i = begin; i <= end; i++) {
            arr[i] = temp[i - begin];
        }
    }

    private void quickSort(int[] arr) {
        hoareQuickSort(arr, 0, arr.length - 1);
    }
    //  挖坑
    private void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;
        int left = begin, right = end;
        int key = arr[begin];
        while (left < right) {
            while (arr[right] >= key && left < right)
                right--;
            arr[left] = arr[right];
            while (arr[left] <= key && left < right)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, begin, left - 1);
        quickSort(arr, left + 1, end);
    }
    //  交换
    private void hoareQuickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
        int key = arr[left];
        while (l < r) {
            while (l < r && arr[r] >= key) r--;
            while (l < r && arr[l] <= key) l++;
            if (l < r) swap(arr, l, r);
        }
        swap(arr, r, left);
        hoareQuickSort(arr, left, l - 1);
        hoareQuickSort(arr, l + 1, right);
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

//    private void swap(int[] arr, int a, int b) {
//        arr[a] = arr[a] ^ arr[b];
//        arr[b] = arr[a] ^ arr[b];
//        arr[a] = arr[a] ^ arr[b];
//    }
}
