package cn.qulei.io.handlerstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Description: 处理流（包装流）
 * @Author: QuLei
 * @CreateDate: 2019-11-12 21:56
 * @Version: 1.0
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("src/ccc.txt");
            osw = new OutputStreamWriter(fos, "utf-8");
            osw.write("瞿雷");
            osw.write("abc");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                osw.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
