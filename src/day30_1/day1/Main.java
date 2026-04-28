package day30_1.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RobinElysia
 * @version 1.0
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
    }
}

@SuppressWarnings("all")
class Solution {
    public int[] plus(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>(); // 创建一个哈希表
        int[] plusnumber = new int[2]; // 创建一个结果数组
        for (int i = 0; i < nums.length; i++) { // 循环数组
            // 判断哈希表里面是否包含target-nums[i]，并且i和hashtable.get(target - nums[i])不相等
            if (hashtable.containsKey(target - nums[i]) && i != hashtable.get(target - nums[i])) {
                // 获取结果数组的第一个值
                plusnumber[0] = hashtable.get(target - nums[i]);
                // 获取结果数组的第二个值
                plusnumber[1] = i;
                return plusnumber;
            }
            // 添加进哈希表
            hashtable.put(nums[i], i);
        }
        return plusnumber;
    }
}