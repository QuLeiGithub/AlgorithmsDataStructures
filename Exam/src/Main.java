import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();*/
        //printCount(string);
        printNum();
    }

    /**
     * @Description: 统计字符个数
     * @author QuLei
     * @date 2019-08-11 19:55
     */
    private static void printCount(String str) {
        int numCount = 0;
        int apCount = 0;
        int spaceCount = 0;
        int otherCount = 0;
        char tem = 0;
        for (int i = 0; i < str.length(); i++) {
            tem = str.charAt(i);
            if ((tem >= 'a' && tem <= 'z') || (tem >= 'A' && tem <= 'Z')) {
                apCount += 1;
            } else if (tem >= '0' && tem <= '9') {
                numCount += 1;

            } else if (tem == ' ') {
                spaceCount += 1;
            } else {
                otherCount += 1;
            }
        }

        System.out.println(numCount + " " + apCount + " " + spaceCount + " " + otherCount);
    }

    /**
     * @Description: 用穷举算法打印所有的组合的数, 要求没有重复的数字
     * @author QuLei
     * @date 2019-08-11 19:52
     */
    private static void printNum() {
        int arr[] = {1, 2, 3, 4};
        List<Integer> resultList = new ArrayList<>();
        int tem = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    for (int k = 0; k < arr.length; k++) {
                        if (i != k && j != k) {
                            tem = arr[i] * 100 + arr[j] * 10 + arr[k];
                            resultList.add(tem);
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int num : resultList) {
            System.out.print(num + " ");
            count++;
            if (count == 8) {
                System.out.println();
                count = 0;
            }
        }

        System.out.println("总共有：" + resultList.size() + "个这样的数");
    }


}


