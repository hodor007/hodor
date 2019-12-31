package com.zp.ms;

import java.util.*;

public class Test {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int low = start;
            int high = end;
            int temp = arr[start];
            while (low < high) {
                while (low < high & arr[high] > temp) {
                    high--;
                }
                if (low < high) {
                    arr[low++] = arr[high];
                }
                while (low < high & arr[low] < temp) {
                    low++;
                }
                if (low < high) {
                    arr[high--] = arr[low];
                }
            }

            arr[low] = temp;
            quickSort(arr, start, low - 1);
            quickSort(arr, low + 1, end);
        }
    }

    public static int query(int[] arr, int start, int end, int value) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (value == arr[mid]) {
            return mid;
        } else if (value > arr[mid]) {
            return query(arr, mid + 1, end, value);
        } else {
            return query(arr, start, mid - 1, value);
        }
    }

    public static void main(String[] args) {
//        int[] arr2 = new int[]{5, 7, 4, 3, 7, 3, 9, 1, 0};
//        System.out.println(Arrays.toString(arr2));
//        quickSort(arr2, 0, arr2.length - 1);
////        System.out.println(Arrays.toString(arr2));
//        int[] arr = {30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
////        System.out.println(myBinarySearch(arr, 40));
//        System.out.println(query(arr, 0, arr.length - 1, 40));

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int x=0;
        int y=0;
        String[] a = input.split(";");
        for(int i=0;i < a.length;i++){
            if( a[i] != null && a[i] != "" && a[i].length()>1 && a[i].length()<4){
                int value = 0;
                try{
                    value =  Integer.valueOf(a[i].substring(1));
                }catch(Exception e){
                    continue;
                }

                if(a[i].charAt(0) == 'A'){
                    x = x - value;
                }else if(a[i].charAt(0) == 'D'){
                    x = x + value;
                }else if(a[i].charAt(0) == 'W'){
                    y = y + value;
                }else if(a[i].charAt(0) == 'S'){
                    y = y - value;
                }
            }
        }
        System.out.println(x + "," +y);
    }

}
