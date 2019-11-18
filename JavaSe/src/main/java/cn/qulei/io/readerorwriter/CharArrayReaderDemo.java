package cn.qulei.io.readerorwriter;

import java.io.*;

/**
 * @Author: QuLei
 * @CreateDate: 2019-11-14 23:41
 * @Version: 1.0
 */
public class CharArrayReaderDemo {
    public static void main(String[] args) throws IOException {
        //char [] chars = new char[]{'a','b','c'};
        char[] chars = "瞿雷是个大帅哥".toCharArray();
        //读取char数组中的数据
        CharArrayReader reader = new CharArrayReader(chars);
        int read = reader.read();
        System.out.println((char) read);
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/abc.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/abc.txt"));
        writer.write("瞿帅哥就是帅");
        writer.append("就是缺个美女");
        writer.newLine();
        writer.flush();
        writer.close();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }

        bufferedReader.close();
    }

}
