package leetBank._008;

class Solution {

    // 解法： 采用StringBuffer收集有效数字，处理好各类边界条件
    public int myAtoi(String str) {
        String str2 = str.trim();
        int len = str2.length();
        if (len  < 1)
            return 0;

        StringBuffer sb = new StringBuffer();
        int res = 1;

        // 第一个非空白字符判断
        char c = str2.charAt(0);
        if (c == '-')
            res = -1;
        else if (c == '+')
            res = 1;
        else if (c >= '0' && c <= '9')
            sb.append(c);
        else
            return 0;

        // 其余字符判断
        for (int i = 1; i < len; i++) {
            c = str2.charAt(i);
            if (c >= '0' && c <= '9')
                sb.append(c);
            else
                break;
        }

        // 字符转整型
        String str3 = sb.toString();
        if (str3.length() == 0)
            return 0;
        try {
            res *= Integer.parseInt(str3);
        } catch (Exception e) {
            if (res == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.myAtoi("-91283472332"));
    }
}