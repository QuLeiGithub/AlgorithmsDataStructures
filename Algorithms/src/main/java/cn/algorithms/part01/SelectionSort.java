package cn.algorithms.part01;


import java.util.Arrays;

/**
 * @author TaoistQu
 */
public class SelectionSort {
    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
    }

    /**
     * 交换数组两位置元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //for test
    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 随机生成随机长度，随机值的数组
     *
     * 对数器
     *
     * 1，你想要测的方法a
     * 2，实现复杂度不好但是容易实现的方法b
     * 3，实现一个随机样本产生器
     * 4，把方法a和方法b跑相同的随机样本，看看得到的结果是否一样
     * 5，如果有一个随机样本使得比对结果不一致，打印样本进行人工干预，改对方法a和方法b
     * 6，当样本数量很多时比对测试依然正确，可以确定方法a已经正确。
     * @param maxSize
     * @param maxValue
     * @return
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] rest = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rest[i] = arr[i];
        }
        return rest;
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) ||
                (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printArray(int[] arr) {
        if (null == arr) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int [] arr = generateRandomArray(maxSize,maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

}
