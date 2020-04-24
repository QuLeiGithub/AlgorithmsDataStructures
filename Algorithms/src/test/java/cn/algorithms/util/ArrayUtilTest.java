package cn.algorithms.util;

import org.junit.Test;

/**
 * 测试比较方法
 */
public class ArrayUtilTest {
    @Test
    public void testSwap() {
        int[] arr = {1, 3};
        ArrayUtil.printArray(arr);
        ArrayUtil.swap(arr, 0, 1);
        ArrayUtil.printArray(arr);
    }
}