package cn.qulei.io.readerorwriter;

import java.io.IOException;
import java.io.PrintStream;

/**
 * 测试打印流
 *
 * @Author: QuLei
 * @CreateDate: 2019-11-18 22:37
 * @Version: 1.0
 */
public class PrintStreamDemo {
    public static void main(String[] args) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(System.out);
            printStream.println(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
