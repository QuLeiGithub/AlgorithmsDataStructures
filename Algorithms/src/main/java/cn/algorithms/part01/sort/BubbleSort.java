package cn.algorithms.part01.sort;

import cn.algorithms.part01.util.ArrayUtil;

/**
 * 测试冒泡排序 时间复杂度为O(n^2)
 *
 * @author TaoistQu
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    ArrayUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            bubbleSort(arr1);
            ArrayUtil.comparator(arr2);
            if (!ArrayUtil.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked!");
        int[] arr = ArrayUtil.generateRandomArray(maxSize, maxValue);
        ArrayUtil.printArray(arr);
        bubbleSort(arr);
        ArrayUtil.printArray(arr);
    }
}
