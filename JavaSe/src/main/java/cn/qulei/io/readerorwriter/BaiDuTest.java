package cn.qulei.io.readerorwriter;

import java.io.*;
import java.net.URL;

/**
 * @author QuLei
 */
public class BaiDuTest {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "utf-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/baidu.html")));
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
