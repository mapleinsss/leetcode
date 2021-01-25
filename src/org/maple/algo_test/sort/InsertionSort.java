package org.maple.algo_test.sort;

import java.util.Arrays;

/**
 * 插入排序 O(n*n)
 * 索引为 0 的值不动，从索引为 1 的值开始遍历，如果比索引为 0 大，那么和索引为 0 的交换位置
 * 例如：
 * 当前遍历的是值为 4：
 * 1 3 5 23 4
 * -> 1 3 5 4 23
 * -> 1 3 4 5 23
 */
public class InsertionSort {

    public static int[] arr = new int[]{5, 3, 1, 23, 4, 2, 8, 6, 7, 10};

    public static int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    j--;
                } else {
                    break;
                }
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
