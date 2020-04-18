package leetBank._006;

public class Solution {
    // 解法： 寻找Z字形字符排列的规律，分析每行字符间隔出现的个数与行数的关系
    public String convert(String s, int numRows) {
        if (numRows <= 1)  // 注意特殊情况
            return s;
        StringBuffer sb = new StringBuffer();
        int down = (numRows - 1) * 2;
        int up = down;
        int down1 = down;
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            boolean flag = true;
            for (int j = i; j < len; ) {
                sb.append(s.charAt(j));
                j += flag ? down : up;
                flag = !flag;
            }
            down = down < 3 ? down1 : down - 2;
            up = up == down1 ? 2 : up + 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = s.convert("A", 1);
        System.out.println(str);
    }
}
