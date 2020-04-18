package cn.algorithms.part01.binary;

import cn.algorithms.part01.util.ArrayUtil;

import java.util.Arrays;

/**
 * 在arr上，找满足<=value的最右位置
 *
 * @author TaoistQu
 */
public class BinarySearchNearRight {
    public static int nearestRightIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
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
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtil.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
            System.out.println("value = " + value);
            System.out.println(nearestRightIndex(arr, value));
            if (test(arr, value) != nearestRightIndex(arr, value)) {
                ArrayUtil.printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearestRightIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
