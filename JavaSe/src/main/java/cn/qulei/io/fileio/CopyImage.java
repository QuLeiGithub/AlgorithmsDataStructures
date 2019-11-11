package cn.qulei.io.fileio;

import java.io.*;

/**
 * 复制图片
 *
 * @author QuLei
 */
public class CopyImage {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("src/IMG_2934.JPG");
            os = new FileOutputStream("src/美女.jpg");
            int len = 0;
            byte[] buff = new byte[1024];
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
