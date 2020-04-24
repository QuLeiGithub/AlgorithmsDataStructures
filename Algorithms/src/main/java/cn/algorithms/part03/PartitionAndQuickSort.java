package cn.algorithms.part03;

import cn.algorithms.util.ArrayUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author TaoistQu
 */
public class PartitionAndQuickSort {

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }

        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                ArrayUtil.swap(arr, index, ++lessEqual);
            }
            index++;
        }
        ArrayUtil.swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    /**
     * arr[L...R]上完荷兰国旗问题划分，以arr[R]为划分值
     * <p>
     * 划分为  < arr[R]  == arr
     *
     * @param arr
     * @param L
     * @param R
     * @return 等于区域的左右边界 res[0] 等于区的左边界 res[1] 等于区的右边界坐标
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{1, 1,};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        //小于区的右边界
        int less = L - 1;
        //大于区域左边界
        int more = R;
        int index = L;
        while (index < more) {
            //等于时啥都不干，看下一个数
            if (arr[index] == arr[R]) {
                index++;
                //当前数小于划分值，当前数与小于区右一个交换，小于区往右扩，跳下一个
            } else if (arr[index] < arr[R]) {
                ArrayUtil.swap(arr, index++, ++less);
                //当前数大于划分值，当前数与大于区的左一个交换，大于区往左扩一个
            } else {
                ArrayUtil.swap(arr, index, --more);
            }
        }
        ArrayUtil.swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);

    }

    /**
     * 时间复杂度为 O(N^2)
     *
     * @param arr
     */
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    /**
     * 时间复杂度 O(N*logN) 求概率累加的期望
     *
     * @param arr
     */
    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        ArrayUtil.swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            int[] arr3 = ArrayUtil.copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!ArrayUtil.isEqual(arr1, arr2) || !ArrayUtil.isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }

}
