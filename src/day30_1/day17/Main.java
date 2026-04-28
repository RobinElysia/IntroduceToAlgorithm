package day30_1.day17;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}

@SuppressWarnings("all")
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int cur = 0;
        for(int i = 0; i < nums.length; i++){
            if(cur < 0){
                cur = 0;
            }
            cur += nums[i];
            maxSub = Math.max(maxSub, cur);
        }
        return maxSub;
    }
}