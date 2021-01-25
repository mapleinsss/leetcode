package org.maple.algo_test.sort;

import java.util.Arrays;

/**
 * @author Mapleinsss
 * @date 2020-12-16
 * <p>
 * 堆排序是一种选择排序，整体主要由构建初始堆 + 交换堆顶元素和末尾元素并重建堆两部分组成。
 * 其中构建初始堆经推导复杂度为 O(n)，在交换并重建堆的过程中，需交换 n-1 次，
 * 而重建堆的过程中，根据完全二叉树的性质，[log2(n-1),log2(n-2)...1] 逐步递减，近似为 nlogn。
 * 所以堆排序时间复杂度一般认为就是O(nlogn)级。
 *
 * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 */
public class HeapSort {

    public static int[] arr = new int[]{5, 3, 1, 23, 4, 2, 8, 6, 7, 10};
//    public static int[] arr = new int[]{9,8,7,6,5,4,3,2,1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        // arr.length = 10,
        for (int i = arr.length - 1; i > 0; i--) {
            buildMaxHeap(arr, i + 1);
            swap(arr, 0, i);
        }
        return arr;
    }

    /**
     * @param length 当前数组取 length 长度来做大堆顶
     */
    public static void buildMaxHeap(int[] arr, int length) {
        // 从最后一个节点的父节点开始向上遍历
        for (int i = length / 2 - 1; i >= 0; i--) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            // 三个值中的最大值索引
            int max;
            // 判断节点存在
            if (right < length) {
                max = arr[left] > arr[right] ? left : right;
                if (arr[max] > arr[i]) {
                    swap(arr, max, i);
                }
            } else if (left < length) {
                max = arr[left] > arr[i] ? left : i;
                // 最大索引是左子节点
                if (max == left) {
                    swap(arr, max, i);
                }
            }
        }
    }

    /**
     * 交换元素
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
