import java.util.*;

/**
 * @Description: 完成找出唯一重复的数字算法
 * * @Author:      QuLei
 * @CreateDate: 2019-08-11 19:49
 * @Version: 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            String in = scanner.next();
            numbers.add(Integer.parseInt(in));
        }
        //System.out.println(numbers);
        System.out.print(find(numbers));*/
        String ipStr = "192.168.1.2";
        int result = Ip2Int(ipStr);
        System.out.println(result);
    }

    /**
     * @return
     * @throws
     * @Description:实现具体的查找算法，主要使用了hash算法
     * @author QuLei
     * @date 2019-08-11 19:49
     */
    public static int find(List<Integer> nums) {
        //请完成该部分内容
        Map<Integer, List<Integer>> numsMap = new HashMap<>();
        Integer tem = 0;
        for (int i = 0; i < nums.size(); i++) {
            tem = nums.get(i);
            List<Integer> list = numsMap.get(tem.hashCode());
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(tem);
            numsMap.put(tem.hashCode(), list);
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = numsMap.entrySet();
        int result = 0;
        for (Map.Entry entrie : entries) {
            List<Integer> list = (List<Integer>) entrie.getValue();
            if (list.size() == 1) {
                result = list.get(0);
                break;
            }
        }
        return result;
    }

    /**
     * @param ipStr 对应的ip地址
     * @return 转化后的数值
     * @Description:将ip地址转换为int
     * @author QuLei
     * @date 2019-08-11 20:03
     */

    public static int Ip2Int(String ipStr) {
        //请完成该部分内容
        String[] arr = ipStr.split("\\.");
        int result = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int ip = Integer.parseInt(arr[arr.length - 1 - i]);
            result |= (ip << (i * 8)) & 0xffffffff;
        }

        return result;
    }
}
