package cn.exam;

/**
 * 十六进制转十进制
 */
public class HexToDecimal {
    public static void main(String[] args) {

        int result = transfer("0x42a");
        System.out.println(result);
        System.out.println(0x42a);
    }

    public static int transfer(String hex) {
        int result = -1;
        if (hex.startsWith("0x") || hex.startsWith("0X")) {
            String str = String.valueOf(hex.substring(2).toLowerCase());
            char[] chars = str.toCharArray();
            result = 0;
            int tem = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    tem = chars[i] - '0';
                } else {
                    tem = chars[i] - 'a' + 10;
                }
                result += tem * Math.pow(16, (chars.length - i - 1));
            }
        }
        return result;
    }
}
