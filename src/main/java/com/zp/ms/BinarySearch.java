package com.zp.ms;

import java.util.Arrays;

/**
 * 二分查找法
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
//        System.out.println(myBinarySearch(arr, 40));
        System.out.println(myBinarySearch2(arr, 40, 0, arr.length - 1));
    }

    private static int myBinarySearch(int[] arr, int i) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (i == arr[mid]) {
                return mid;
            }
            if (i < arr[mid]) {
                high = mid - 1;
            }
            if (i > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int myBinarySearch2(int[] arr, int i, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (i == arr[mid]) {
            return mid;
        } else if (i < arr[mid]) {
            return myBinarySearch2(arr, i, start, mid - 1);
        } else {
            return myBinarySearch2(arr, i, mid + 1, end);
        }
    }
}
