package org.maple.algo_test.search;

/**
 * 二分查找
 * 只能查找已经排序好的数据，通过比较中间值，缩小范围
 * 复杂度：O(logn)
 */
public class BinSearch {

    private static final int[] arr = {1, 4, 8, 16, 45, 48, 78, 99};


    public static void main(String[] args) {
        int index = recursionBinarySearch(arr, 45, 0, arr.length - 1);
        int index2 = commonBinarySearch(arr, 45);
        System.out.println(index);
        System.out.println(index2);
    }

    /**
     * 通过递归的方式
     */
    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (arr[middle] > key) {
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }

    /**
     * 通过循环的方式
     */
    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle;

        if (key < arr[low] || key > arr[high]) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
