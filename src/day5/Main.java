package day5;


/**
 * @author RobinElysia
 * @version 1.0
 */
@SuppressWarnings("all")
public class Main {
}

@SuppressWarnings("all")
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) { // 初始化
            sb[i] = new StringBuilder();
        }

        int len = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < len;) {
            for (int j = 0; j < numRows && i < len; j++) { // 从上到下
                sb[j].append(chars[i]);
                i++;
            }
            for (int j = numRows - 2; j > 0 && i < len; j--) { // 从下到上
                sb[j].append(chars[i]);
                i++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sbi : sb){
            res.append(sbi);
        }

        return res.toString();
    }
}