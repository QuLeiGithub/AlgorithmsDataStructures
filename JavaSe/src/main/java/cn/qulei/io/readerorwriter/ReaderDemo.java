package cn.qulei.io.readerorwriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 一个字符一个字符读
 *
 * @author QuLei
 */
public class ReaderDemo {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = new FileReader("src/abc.txt");

            int read;
            while ((read = reader.read()) != -1) {
                System.out.println((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
