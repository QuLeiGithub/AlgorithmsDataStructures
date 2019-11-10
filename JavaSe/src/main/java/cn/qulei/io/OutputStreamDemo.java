package cn.qulei.io;

import java.io.*;

/**
 * 复制文件
 *
 * @author QuLei
 */
public class OutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("aaa.txt");
        OutputStream os = null;
        InputStream is = null;
        try {
            is = new FileInputStream("src/abc.txt");
            os = new FileOutputStream(file);
            byte buff[] = new byte[1024];
            int len = 0;
            while ((len = is.read(buff)) != -1) {
                os.write(buff, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
