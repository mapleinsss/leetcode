package org.maple.algo_test.sort;

import java.util.Arrays;

/**
 * 冒泡排序 O(n*n)
 * 循环一次，把当前遍历的值和下一个值比较，如果当前值大，那么和下一个值交换位置，继续向后比较
 */
public class BubbleSort {

    public static int[] arr = new int[]{5, 3, 1, 23, 4, 2, 8, 6, 7, 10};

    public static int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int j = 0;
            while (j < (arr.length - 1 - i)) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
                j++;
            }
        }
        return arr;
    }

    /**
     * 交换元素
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(arr)));
    }
}
