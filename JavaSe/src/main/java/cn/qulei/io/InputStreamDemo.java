package cn.qulei.io;

import java.io.*;

/**
 * @author QuLei
 */
public class InputStreamDemo {
    public static void main(String[] args)  {
        InputStream is =null;
        try {

            is = new FileInputStream(new File("src/abc.txt"));
            int length = 0;
            while ((length = is.read())!=-1){
                System.out.println((char) length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
