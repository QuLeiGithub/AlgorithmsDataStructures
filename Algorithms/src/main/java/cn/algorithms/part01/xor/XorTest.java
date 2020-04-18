package cn.algorithms.part01.xor;

/**
 * 测试异或
 * 异或运算：相同为0，不同为1
 * 同或运算：相同以1，不同为0
 * <p>
 * 能长时间记住的概率接近0%
 * <p>
 * 所以，异或运算就记成无进位相加！
 * <p>
 * 0 1 1 0
 * 0 1 0 0
 * 0 0 1 0
 * <p>
 * <p>
 * 异或运算的性质
 * <p>
 * 1) 0^N == N      N^N == 0
 * 2)异或运算满足交换律和结合率
 * <p>
 * 上面的两个性质用无进位相加来理解就非常的容易
 *
 * @author TaoistQu
 */
public class XorTest {
    /**
     * 如何不用额外变量交换两个数
     */
    public static void main(String[] args) {
        int a = 6;
        int b = -1000;
        //将 a = x   b = y
        a = a ^ b;  // a ==> x^y  b ==>y
        b = a ^ b;  // b ==> x^y^y ==> x^0 == > x    a ==>x^y
        a = a ^ b; // x^y^x  ==> 0^y == > y
        System.out.println(a);
        System.out.println(b);
    }
}
