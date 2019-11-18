package cn.qulei.io.readerorwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author QuLei
 */
public class ExitTest {
    public static void main(String[] args) {

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            String str = "";
            while (!str.equals("exit")) {
                str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
