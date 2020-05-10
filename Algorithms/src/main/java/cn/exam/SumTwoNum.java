package cn.exam;

import java.util.HashMap;

/**
 * 在数组中找到两个元素的索引，且这两个元素相加等于目标值
 * @author TaoistQu
 */
public class SumTwoNum {
    public static void main(String[] args) {
        int target = 18;
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSum2(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }

    /**
     * 暴力遍历  时间复杂度为O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * O(N) 时间复杂度
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int dif = 0;

        for (int i = 0; i < nums.length; i++) {
            dif = target - nums[i];
            if (map.containsKey(dif)) {
                return new int[]{i, map.get(dif)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
