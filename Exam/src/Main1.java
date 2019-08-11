import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            String in = scanner.next();
            numbers.add(Integer.parseInt(in));
        }
        //System.out.println(numbers);
        System.out.print(find(numbers));
    }

    public static int find(List<Integer> nums) {
        //请完成该部分内容
        Map<Integer,List<Integer>> numsMap = new HashMap<>();
        Integer tem = 0 ;
        for (int i = 0 ; i < nums.size();i++){
            tem = nums.get(i);
            List<Integer> list = numsMap.get(tem.hashCode());
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(tem);
            numsMap.put(tem.hashCode(),list);
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = numsMap.entrySet();
        int result = 0 ;
        for (Map.Entry entrie:entries) {
            List<Integer> list= (List<Integer>) entrie.getValue();
            if(list.size() == 1){
                result =  list.get(0);
                break;
            }
        }
        return result;
    }


    /*public static int Ip2Int(String ip) {
        //请完成该部分内容
        String[] arr = ip.split(".");
        byte [] ints = new byte[32];
        for (String str: arr) {

        }

        new Integer(ints);
    }*/
}
