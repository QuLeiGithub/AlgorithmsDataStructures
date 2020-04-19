package cn.algorithms.part01.xor;

/**
 * 异或操作的应用
 *
 * @author TaoistQu
 */
public class EvenTimesOddTimes {
    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        //011001000
        //000001000
        int rightOne = eor & (~eor + 1); // 提取出最右的1   取反加1在与自身作与运算
        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    /**
     * 提取一个数字二进制中1的个数
     *
     * @param N
     * @return
     */
    public static int bit1Counts(int N) {
        int count = 0;
        while (N != 0) {
            //计算出最右边的 1
            int rightOne = N & ((~N) + 1);
            count++;
            //抹掉最右边的 1
            N ^= rightOne;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        printOddTimesNum2(arr2);


        int bit1Counts = bit1Counts(14);
        System.out.println("一个数二进制中1的个数：" + bit1Counts);

    }
}
