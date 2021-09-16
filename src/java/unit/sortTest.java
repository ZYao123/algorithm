package unit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class sortTest {
    @Test
    public void SortTester() {
        int size = 100;
        boolean success = true;
        for (int testCount = 0; testCount < 1000; testCount++) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = (int) (Math.random() * size * size);
            }
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            quickSort(arr1);

            int[] arr2 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);

            Assert.assertArrayEquals(arr1, arr2);
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
        quickSort(arr, 0, arr.length - 1);
    }

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

    private void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
