package org.maple.algo_test.sort;

import java.util.Arrays;

/**
 * 选择排序 O(n*n)
 * 线性遍历，第一次遍历完成后，把最小值放在第一位，然后去掉第一位，继续遍历数组执行第一次的操作
 */
public class SelectionSort {

    public static int[] arr = new int[]{5, 3, 1, 23, 4, 2, 8, 6, 7, 10};

    public static int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        // 外层循环，每次剔除掉一位最小值
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 内层循环，找出最小值的索引，然后把当前循环头部的值变为最小值
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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
