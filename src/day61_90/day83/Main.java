package day61_90.day83;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        // 第一行始终是 [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        // 从第二行开始生成
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> prevRow = triangle.get(rowNum - 1);
            List<Integer> curRow = new ArrayList<>();

            // 每行第一个元素为 1
            curRow.add(1);

            // 中间元素 = 上一行相邻两元素之和
            for (int j = 1; j < rowNum; j++) {
                curRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // 每行最后一个元素为 1
            curRow.add(1);

            triangle.add(curRow);
        }

        return triangle;
    }
}