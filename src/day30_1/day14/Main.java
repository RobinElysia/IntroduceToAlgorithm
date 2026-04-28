package day30_1.day14;

import java.util.HashMap;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
    }
}

@SuppressWarnings("all")
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (integerIntegerHashMap.containsKey(sum - k)){
                res += integerIntegerHashMap.get(sum - k);
            }
            integerIntegerHashMap.put(sum, integerIntegerHashMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}