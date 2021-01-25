package org.maple.algo_test.heap;

import java.util.Arrays;

/**
 * @author Mapleinsss
 * @date 2020-12-15
 * 构建最大堆
 * 从最后一个节点的父节点（arr.length / 2 - 1）开始 逐次调整位置，开始构建最大堆
 * 若父节点小于左节点，父节点与左节点互换，继续调整
 * 若父节点小于右节点，父节点与右节点互换，继续调整
 * <p>
 * 堆常用公式：
 * 最后一个父节点：arr.length / 2 -1
 * 父节点：parent(i) = floor((i - 1) / 2)
 * 左子节点：left(i)   = 2i + 1
 * 右子节点 right(i)  = 2i + 2
 */
public class BuildMaxHeap {

    public static int[] arr = new int[]{5, 3, 1, 23, 4, 2, 8, 6, 7, 10};
//    public static int[] arr = new int[]{5, 3, 1, 23, 4, 2, 8};

    public static void main(String[] args) {
        adjustHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void adjustHeap(int[] arr) {
        // 从最后一个节点的父节点开始向上遍历
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            // 三个值中的最大值索引
            int max = i;
            // 判断节点存在
            if (right < arr.length) {
                max = arr[left] > arr[right] ? left : right;
                if (arr[max] > arr[i]) {
                    swap(arr, max, i);
                }
            } else if (left < arr.length) {
                max = arr[left] > arr[i] ? left : i;
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
