package cn.qulei.io.handlerstream;

import java.io.*;

/**
 * @Description:使用处理流拷贝文件
 * @Author: QuLei
 * @CreateDate: 2019-11-12 21:58
 * @Version: 1.0
 */
public class CopyFile {
    public static void main(String[] args) {
        OutputStreamWriter osw = null;
        InputStreamReader isr = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream("src/new.txt"));
            isr = new InputStreamReader(new FileInputStream("src/abc.txt"));
            int len = 0;
            char[] chars = new char[2048];
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                osw.close();
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
