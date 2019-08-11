/**
 * @Description:  测试类静态资源加载过程，静态变量和静态块依次由上向下加载，且可以有多个
 ** @Author:      QuLei
 * @CreateDate:   2019-08-11 18:23
 * @Version:      1.0
 */
public class Test {

    public static int i = 5;

    static {
        System.out.println("i+++="+i);
        i = i * 10 + 5;
        System.out.println("the first: "+i);
    }

    public static void main(String[] args) {
        System.out.println(i);
    }

    static {
        System.out.println("i======="+i);
        i /= 3;
        System.out.println("the second:"+i);
    }
}
