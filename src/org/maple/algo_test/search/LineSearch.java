package org.maple.algo_test.search;

/**
 * 线性查找
 * 线性查找又称顺序查找，是一种最简单的查找方法
 * 它的基本思想是从第一个记录开始，逐个比较记录的关键字，直到和给定的K值相等，则查找成功；若比较结果与文件中n个记录的关键字都不等，则查找失败
 * 线性查找可以的数列可以是有序的也可以是无序的
 *
 * 复杂度 O(n)
 */
public class LineSearch {

    private static final int[] arr = {11, 5, 32, 41, 31, 6, 23, 64, 83};

    /**
     * 返回索引该值第一次出现的索引
     */
    public static int orderSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(orderSearch(arr, 5));
    }
}
