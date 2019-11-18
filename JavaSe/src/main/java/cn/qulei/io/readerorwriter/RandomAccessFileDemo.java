package cn.qulei.io.readerorwriter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 测试随机访问流来进行文件切割读取
 *
 * @Author: QuLei
 * @CreateDate: 2019-11-18 22:47
 * @Version: 1.0
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        File file = new File("src/doc.txt");
        long length = file.length();
        int blockSize = 1024;
        int size = (int) (Math.ceil(length * 1.0 / blockSize));
        System.out.printf("文件要被切成<%d>块", size);
        System.out.println();
        int beginPos = 0;
        int actualSize = (int) (blockSize < length ? blockSize : length);
        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {
                actualSize = (int) length;
            } else {
                actualSize = blockSize;
                length -= blockSize;
            }
            System.out.printf(i + "------》起始位置为:%d,--->读取的大小为：%d", beginPos, actualSize);
            System.out.println();
            readSplit(beginPos, actualSize);
        }
    }

    /**
     * @param
     * @return
     * @throws
     */
    public static void readSplit(int beginPos, int actualSize) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("src/doc.txt"), "r");
            randomAccessFile.seek(beginPos);
            byte[] bytes = new byte[512];
            int len = 0;
            while ((len = randomAccessFile.read(bytes)) != -1) {
                if (actualSize > len) {
                    System.out.println(new String(bytes, 0, len));
                    System.out.println("第1次");
                    actualSize -= len;
                } else {
                    System.out.println(new String(bytes, 0, actualSize));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
