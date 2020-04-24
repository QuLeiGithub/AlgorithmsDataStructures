package cn.algorithms.part01.sort;

import cn.algorithms.util.ArrayUtil;

/**
 * 插入排序 时间复杂度 O(n^2)
 *
 * @author TaoistQu
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //外层拿数
        for (int i = 1; i < arr.length; i++) {
            //内层比较交换
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                ArrayUtil.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            insertionSort(arr1);
            ArrayUtil.comparator(arr2);
            if (!ArrayUtil.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = ArrayUtil.generateRandomArray(maxSize, maxValue);
        ArrayUtil.printArray(arr);
        insertionSort(arr);
        ArrayUtil.printArray(arr);
    }
}
