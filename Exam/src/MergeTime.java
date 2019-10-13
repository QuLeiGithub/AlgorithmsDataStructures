/**
 * @author QuLei
 * <p>
 * 合并时间区间（建议时间复杂度 O(n) ）
 * 给定⼀个按开始时间从⼩到⼤排序的时间区间集合，请将重叠的区间合并。时
 * 间区间集合⽤⼀个⼆维数组表示，⼆维数组的每⼀⾏表示⼀个时间区间（闭区
 * 间），其中 0 位置元素表示时间区间开始， 1 位置元素表示时间区间结束。
 * 例 1：输⼊： [ [1, 3], [2, 6], [8, 10], [15, 18] ]
 * 返回： [ [1, 6], [8, 10], [15, 18]]
 * 解释：时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
 * 例 2：输⼊： [[1, 4], [4, 5]]
 * 返回： [[1, 5]]
 * 解释：时间区间[1， 4] 和 [4， 5]重叠了⼀个时间点，合并之后为 [1， 5]
 * 需要实现的⽅法原型： int[][] merge(int[][] intervals)
 */
public class MergeTime {
    public static void main(String[] args) {
        //int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {17, 20}};
        //int intervals[][] = {{1, 4}, {4, 5}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        int count = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][0] == intervals[i + 1][0]) {
                break;
            }
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i][1] = intervals[i + 1][1];
                for (int j = i + 1; j < intervals.length - 1; j++) {
                    intervals[j][0] = intervals[j + 1][0];
                    intervals[j][1] = intervals[j + 1][1];
                }
                count++;
            }
        }
        int[][] result = new int[intervals.length - count][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }
}
