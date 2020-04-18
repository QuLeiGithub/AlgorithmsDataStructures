package cn.algorithms.part01.binary;

import cn.algorithms.part01.util.ArrayUtil;

/**
 * 测试寻找在无序中的一个局部极小位置
 *
 * @author TaoistQu
 */
public class BinarySearchAwsome {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //处理左边界
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        //处理右边界
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                //类似于梯度下降,这种情况说明跑右边了，需要往左走
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.generateRandomArray(30, 50);
        int index = getLessIndex(arr);
        ArrayUtil.printArray(arr);
        if (index == -1) {
            System.out.println("没有获得！！！");
        } else if (index == 0) {
            System.out.println("arr[0]= " + arr[0]);
            System.out.println("arr[1]= " + arr[1]);
        } else if (index == arr.length - 1) {
            System.out.println("arr[length-1]= " + arr[arr.length - 1]);
            System.out.println("arr[length-2]= " + arr[arr.length - 2]);
        } else {
            System.out.println(arr[index - 1]);
            System.out.println(arr[index]);
            System.out.println(arr[index + 1]);
        }
    }
}
