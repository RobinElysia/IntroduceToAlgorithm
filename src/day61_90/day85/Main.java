package day61_90.day85;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int numSquares(int n) {
        // 1. 判断是否是完全平方数 -> 答案为 1
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return 1;
        }

        // 2. 判断是否可以表示为两个平方数之和 -> 答案为 2
        for (int i = 0; i <= sqrt; i++) {
            int rem = n - i * i;
            int remSqrt = (int) Math.sqrt(rem);
            if (remSqrt * remSqrt == rem) {
                return 2;
            }
        }

        // 3. 判断是否满足 4^a * (8b + 7) 形式 -> 答案为 4，否则为 3
        int temp = n;
        while (temp % 4 == 0) {
            temp /= 4;
        }
        if (temp % 8 == 7) {
            return 4;
        }
        return 3;
    }
}