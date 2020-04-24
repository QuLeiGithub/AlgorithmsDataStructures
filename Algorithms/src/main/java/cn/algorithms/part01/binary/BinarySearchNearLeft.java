package cn.algorithms.part01.binary;

import cn.algorithms.util.ArrayUtil;

import java.util.Arrays;

/**
 * 在arr上，找到满足 > value的最左边位置
 *
 * @author TaoistQu
 */
public class BinarySearchNearLeft {
    public static int nearestLeftIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    /**
     * for test  对数器
     *
     * @param arr
     * @param value
     * @return
     */
    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtil.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
            System.out.println("value = " + value);
            System.out.println(nearestLeftIndex(arr, value));
            if (test(arr, value) != nearestLeftIndex(arr, value)) {
                ArrayUtil.printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearestLeftIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
