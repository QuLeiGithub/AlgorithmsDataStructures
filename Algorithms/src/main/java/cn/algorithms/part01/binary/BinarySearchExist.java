package cn.algorithms.part01.binary;

import cn.algorithms.part01.sort.SelectionSort;
import cn.algorithms.part01.util.ArrayUtil;

/**
 * 二分查找数是否存在
 *
 * @author TaoistQu
 */
public class BinarySearchExist {
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length-1;
        int mid = 0;
        while (L < R) {
            // mid = (L+R) / 2  如果 L为10亿 R为18亿 时 (L+R)溢出
            // N /2 = N >> 1  N*2 = N <<1   N*2+1 = ((N<<1)| 1 )
            mid = L + ((R - L) >> 2);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.generateRandomArray(100, 100);
        SelectionSort.selectionSort(arr);
        boolean exist = exist(arr, 0);
        ArrayUtil.printArray(arr);
        System.out.println(exist);
    }
}
