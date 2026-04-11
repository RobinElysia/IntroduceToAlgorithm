package day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = solution.merge(intervals);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}

@SuppressWarnings("all")
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // 排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}